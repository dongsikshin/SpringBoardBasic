/*
 * mybatis�� ���������� �о�鿩��, ������ ����� �ʿ��� SqlSession �� ����ϱ� ����!!
 * mybatis���� ������ ���� ��ü�� �ٷ� SqlSessin �̴�!!
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
	//���̻� �ܺ��� � ��ü��, ������ ȣ��δ� �� ��ü�� ������ �� ����!!
	//���� �Ʒ��� getter �޼��带 ���ؼ��� �ν��Ͻ��� �����ؾ� �Ѵ�..
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
	
	//���� ���丮�κ��� SqlSession�� ����� �� �� �ֵ��� �޼��带 ����������!!
	public SqlSession getSession(){
		return sqlSessionFactory.openSession();
	}
	
	//�� SqlSession �� �ݴ� �޼��� 
	public void closeSession(SqlSession session){
		session.close();
	}
}










