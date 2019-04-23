package com.dangducluan.springconfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer{
	@Bean
	public DriverManagerDataSource dataSource() throws IOException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		Properties properties = new Properties();
		InputStream user_props = this.getClass().getResourceAsStream("/application.properties");
		properties.load(user_props);
		dataSource.setDriverClassName(properties.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(properties.getProperty("spring.datasource.url"));
		dataSource.setUsername(properties.getProperty("spring.datasource.username"));
		dataSource.setPassword(properties.getProperty("spring.datasource.password"));
		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		Resource resource = new ClassPathResource("SqlMapConfig.xml");
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setConfigLocation(resource);
		return sessionFactoryBean;
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.dangducluan.mapper");
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return mapperScannerConfigurer;
	}
}
