package com.example.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// 스프링 부트 스타터에서는 의존관계에 대한 처리 뿐 아니라 의존전이까지도 자동화 하였다.
// 서버기동 시 스캔함
@Configuration //spring-data.xml
//@PropertySource("classpath:/application.properties") - 단점은 반복된다.
@PropertySource("classpath:/application.yml") // 내려쓰기와 들여쓰기로 반복을 피한다.
//@MapperScan(basePackages = "com.example.demo.mapper")
public class DatabaseConfiguration { //NullPointerException ->  BeanCreationException
	private static final Logger logger = LogManager.getLogger(DatabaseConfiguration.class);
	//Bean있는 메소드는 byName,  byType호출이 가능함
	//하드코딩 하지 말고 메소드의 리턴타입으로 객체 주입함 - 결합도 낮추는 코드전개 한가지
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() { //오라클제품이구나, url수집()
		return new HikariConfig(); //생성자 호출 - 상위 클래스 생성자도 먼저 호출된다.(안드로이드개발)
	}
	//JDBC API에서 Connection(I), DriverManager(Class) -> getConnection(url, scott,tiger)
	//PreparedStatement pstmt = con.preparedStatement();
	//java.sql.Connection, java.sql.DriverManager
	//javax.sql.DataSource - 원격(로컬:클라우드)에 있는 객체를 호출 할 수있는 기능이 필요했다~~~

	@Bean
	public DataSource dataSource() { //오라클 제품
		//데이터 소스를 생성하기 위해서 나는 오라클 서버에 대한 정보가 필요했다
		//파라미터로 그 정보를 수집한 객체를 넣어줘 - 커넥션을 맺는데 사용함
		DataSource dataSource = new HikariDataSource(hikariConfig());
		logger.info("datasource : {}", dataSource);
		return dataSource;
	}
	// ApplicationContext는 스프링이 제공하는 컨테이너 이다.
	// 역할: 여러가지 빈을 관리해준다 -> 객체 라이프사이클 관리해줌
	// 클래스 이름 앞에 @Autowired를 사용하였다.
	// DatabaseConfiguration.java

	@Autowired //그물 엮는다 의미 - 의존성 주입관련 어노테이션
	private ApplicationContext applicationContext;

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		//setter -  파라미터로 넘어온 값이 전변에 초기화
		sqlSessionFactoryBean.setDataSource(dataSource);
		//classpath는 src/main/resourcs이고 해당 쿼리가 있는 xml 위치는 본인의 취향대로 위치키시고 그에 맞도록 설정해주면 된다.
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}	
}/*
 * NoticeDao와 오라클 서버를 myBatis 라이브러리를 활용해서 연동하기
 * myBatis팀에서 spring boot에서 사용할 수 있도록 클래스를 너희가 제공해줘
 * NoticeDao - SqlSessionFactoryBean(mybatis-spring.jar) - 오라클서버
 * 
 * 디폴트 빈 컨테이너 - ApplicationContext - 이른 객체 주입 - 빈이름을 너(설계)가 등록(결정해줘)해줘
 * 어디다가?  - DatabaseConfiguration.java - 단 클래스 선언 앞에 @Configuration을 붙여줘 - 여기서 챚을께
 * - 객체 생성 -  A a = null(A a= new A():코드수정양이 많아진데,라이프사이클관리직접)
 * -  byName(ac.getBean("noticeController")), byType(ac.getBean(NoticeController.class)) 생성해줄께
 * - @Bean 붙여서 선언해 줄것 - 단 클래스 이름 앞에 반드시 @Configuration
 * - @Configuration과 @Bean 한 쌍으로 존재
 */