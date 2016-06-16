/*
 * mybatis의 설정파일을 읽어들여서, 쿼리문 수행시 필요한 SqlSession 을 취득하기 위함!!
 * mybatis에서 쿼리문 수행 객체는 바로 SqlSessin 이다!!
 * */
package mybatis.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {
	private static MybatisConfig instance;
	SqlSessionFactory sqlSessionFactory;
	
	private MybatisConfig(){
		init();
	}
	//더이상 외부의 어떤 객체가, 생성자 호출로는 이 객체를 생성할 수 없다!!
	//따라서 아래의 getter 메서드를 통해서만 인스턴스를 생성해야 한다..
	public static MybatisConfig getInstance() {
		if(instance == null){
			instance= new MybatisConfig();
		}
		return instance;
	}
	public void init(){
		try {
			InputStream is=Resources.getResourceAsStream("mybatis/config/config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//세션 팩토리로부터 SqlSession을 취득해 갈 수 있도록 메서드를 제공해주자!!
	public SqlSession getSession(){
		return sqlSessionFactory.openSession();
	}
	
	//얻어간 SqlSession 을 닫는 메서드 
	public void closeSession(SqlSession session){
		session.close();
	}
}










