package com.javatzxx.android.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.javatzxx.android.entity.UserEntity;


//@Repository(value="androidMusicDao")
public class AndroidMusicDao extends HibernateDaoSupport{
	
	//不写这个就报错不能实例化擦
//		 @Resource(name="sessionFactory")
//		    private SessionFactory sessionFactory;
//		    public void setMySessionFacotry(SessionFactory sessionFacotry) {     
//		        this.sessionFactory = sessionFacotry;     
//		       }     
//		    @PostConstruct    
//		    public void injectSessionFactory() {     
//		        super.setSessionFactory(sessionFactory);     
//		    }     
//
//		public void create(UserEntity user) {
//			// TODO Auto-generated method stub
//			String s=(String) super.getHibernateTemplate().save(user);
//			System.out.println("s");
//		}
//
//		public List<UserEntity> query(UserEntity user) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		public void createOrUpdate(UserEntity user) {
//			// TODO Auto-generated method stub
//			super.getHibernateTemplate().saveOrUpdate(user);
//		}
//
//		public void delete(UserEntity user) {
//			// TODO Auto-generated method stub
//			super.getHibernateTemplate().delete(user);
//		}
//
//		public UserEntity queryUserById(String userid) {
//			// TODO 自动生成的方法存根
//			System.out.println("调用的BYId方法");
//			return super.getHibernateTemplate().get(UserEntity.class, userid);
//		}
//
//		public UserEntity queryUserByName(String username) {
//			// TODO 自动生成的方法存根
//			System.out.println("调用的BYName方法");
//			List<UserEntity> lst=(List<UserEntity>) super.getHibernateTemplate().find("from UserEntity u where u.name=?", username);
//			 if(lst.size()>0){
//				 UserEntity u=lst.get(0);
//				 System.out.print(u);
//				return u;  
//			 }else{
//				 return null;
//			 }
//			
//				
//			}

}
