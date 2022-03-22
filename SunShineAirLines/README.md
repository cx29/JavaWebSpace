# Ioc
## scope属性
### 用于控制bean创建后的对象是否是单例的
* prototype:非单例
* 默认为单例bean,也可以写singleton
### 应用场景
* 应用于如果有特性化的数据则要用非单例bean
* 单例情况下,bean是在加载spring容器的时候创建的
* 非单例情况下,bean是在获取对象的时候创建的.
## bean的生命周期
* init-method:与单例和非单例有关,单例只执行一次 
* destroy-method:非单例时不运行,spring只是帮忙创建对象,但是对象不归spring容器管理
## bean对象创建方式
1. factory-bean,实例工厂  
***
    package cn.tn;
    import cn.tn.service.UserService;
    import cn.tn.service.impl.UserServiceImpl;
    public class UserServiceFactory {
        public  UserService getService(){
            return new UserServiceImpl();
        }
    }
***
2. factory-method,静态工厂
***
    package cn.tn;
    import cn.tn.service.UserService;
    import cn.tn.service.impl.UserServiceImpl;
    public class UserServiceFactory {
        public static  UserService getService(){
            return new UserServiceImpl();
        }
    }  
***
## DI 依赖注入
### set注入  
- service注入dao(引用类型)  
   对需要注入的变量添加set方法  
***
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }  
***
配置文件  
***
    <bean id="userService" class="cn.tn.service.impl.UserServiceImpl">
    <!-- name写属性名,ref写注入的资源名-->
		<property name="userDao" ref="userDao1"/>
	</bean>
	<!--	将注入的资源声明为bean-->
	<bean id="userDao1" class="cn.tn.service.impl.UserDaoImpl"/>
***
