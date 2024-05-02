# MyBatis

> **Java Object와 SQL문 사이의 자동 Mapping 기능을 지원하는 ORM Framework**
> 

## **MyBatis의 특징**

- **쉬운 접근성과 코드의 간결함**
    - XML 형태로 서술된 JDBC 코드라 생각해도 될 만큼 JDBC의 모든 기능을 MyBatis가 대부분 제공한다.
    - JDBC 코드를 전부 걷어낸다.
    - 수동적인 parameter 설정이 아님
- **SQL문과 프로그래밍 코드의 분리**
    - SQL에 변경이 있을 때 마다 자바 코드를 수정하지 않아도 됨
- **Java뿐만 아닌 다른 언어로도 구현 가능**

## **MyBatis 사용법**

### **XML을 이용한 설정법**

- `**mybatis-config.xml**`
    
    ```jsx
    <properties resource="mapper/dbinfo.properties"/>
    
    	<environments default="development">
            <environment id="development">
                <transactionManager type="JDBC"/>
                <dataSource type="POOLED">
                    <property name="driver" value="${driver}"/>
                    <property name="url" value="${url}"/>
                    <property name="username" value="${dbid}"/>
                    <property name="password" value="${dbpwd}"/>
                </dataSource>
            </environment>
        </environments>
    ```
    
    - 데이터베이스와의 연결을 위한 설정
    
    ```jsx
      <mappers>
    		<mapper resource="mapper/member.xml" />
    		<mapper resource="mapper/board.xml" />
    	</mappers>
    ```
    
    - 데이터베이스에 전달할 정보를 매핑 하는 부분
    
    ```jsx
    	<typeAliases>
    		<typeAlias type="com.ssafy.mybatis.model.MemberDto" alias="memberDto" />
    	</typeAliases>
    ```
    
    - 추후 연결을 위한 *alias* 설정

- **기존의 DBUtils를 대신하는 파일**
    
    ```jsx
    	private static SqlSessionFactory sqlSessionFactory;
    
    	static {
    		try {
    			String resource = "mapper/mybatis-config.xml";
    			Reader reader = Resources.getResourceAsReader(resource);
    			factory = new SqlSessionFactoryBuilder().build(reader);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    
    	public static SqlSession getSqlSession() {
    		return factory.openSession();
    	}
    ```
    
    - `mybatis-cofig.xml` 을 생성해서 db와 연결하는 `getSqlSession()` 을 만든다.
    - 이를 활용해 DaoImpl에서 session을 받는다.
- `**BoardDaoImpl**`
    
    ```jsx
    	private final String NAMESPACE = "com.ssafy.board.model.dao.BoardDao.";
    
    	@Override
    	public List<BoardDto> listArticle(Map<String, Object> map) throws SQLException {
    		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
    			return sqlSession.selectList(NAMESPACE + "listArticle", map);
    		}
    	}
    ```
    
    - `sqlSession.selectList(NAMESPACE + "listArticle", map);` 의 경우 **com.ssafy.member.model.dao.BoardDao.listArticle**로 매핑된다.]
    
- `board.xml`
    
    ```jsx
    <mapper namespace="com.ssafy.board.model.dao.BoardDao">
    
    	<resultMap type="boardDto" id="article">
    		<result column="article_no" property="articleNo"/>
    		<result column="user_id" property="userId"/>
    		<result column="user_name" property="userName"/>
    		<result column="subject" property="subject"/>
    		<result column="content" property="content"/>
    		<result column="hit" property="hit"/>
    		<result column="register_time" property="registerTime"/>
    	</resultMap>
    	
    	<resultMap type="boardDto" id="viewArticle" extends="article">
    		<collection property="fileInfos" column="article_no" javaType="list" ofType="fileInfoDto" select="fileInfoList"/>
    	</resultMap>
    	
    	<resultMap type="fileInfoDto" id="file">
    		<result column="save_folder" property="saveFolder"/>
    		<result column="original_file" property="originalFile"/>
    		<result column="save_file" property="saveFile"/>
    	</resultMap>
    	
    		<select id="listArticle" parameterType="map" resultMap="article">
    		select b.article_no, b.user_id, b.subject, b.content, b.hit, b.register_time, m.user_name
    		from board b, members m 
    		where b.user_id = m.user_id
    		<include refid="search"></include>
    		order by b.article_no desc
    		limit #{start}, #{listsize}
    	</select>
    ```
    
    - 수 없이 많은 `.xml` 중에서는 `<mapper namespace="com.ssafy.board.model.dao.BoardDao">` 을 통해 맞는 `board.xml` 을 찾는다.
    - mapper 네이밍은 패키지로 정한다.
        - 하위의 클래스의 이름의 개별성을 보장한다.
    - 맞는 sql문을 실행하고 결과를 **resultMap**을 활용해 return 한다.
        - 이 **resultMap**은 사전에 만들어 놓는다. (return 값의 사전 형식)
        - 이 코드에 경우 **boarddto** 객체를 property 주입으로 만들어 return 한다.
        - `<properties resource=*"mapper/dbinfo.properties"*/>`
    

## MyBatis-Spring

- mybatis를 조금 더 줄일 수 있을까?

### 기존의 db 연결

```jsx
<properties resource="mapper/dbinfo.properties"/>

	<environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${driver}"/>
                <property name="url" value="${url}"/>
                <property name="username" value="${dbid}"/>
                <property name="password" value="${dbpwd}"/>
            </dataSource>
        </environment>
    </environments>
```

**root-context.xml** 에 다음과 같이 설정

```jsx
	<bean id="dataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
		<property name="jndiName" value="java:comp/env/jdbc/ssafy"></property>
	</bean>
```

- 더이상 위의 config 파일은 사라져도 가능하다.
- *mapper/dbinfo.properties* **또한 삭제가 가능!**

### 기존의 alias 및 xml 설정

```jsx
	<typeAliases>
		<typeAlias type="com.ssafy.board.model.BoardDto" alias="boardDto" />
		<typeAlias type="com.ssafy.board.model.FileInfoDto" alias="fileInfoDto" />
		<typeAlias type="com.ssafy.member.model.MemberDto" alias="memberDto" />
	</typeAliases>
    
    <mappers>
		<mapper resource="mapper/member.xml" />
		<mapper resource="mapper/board.xml" />
	</mappers>
```

**root-context.xml** 에 다음과 같이 설정

```jsx
	<bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"/>
		<property name="typeAliasesPackage" value="com.ssafy.*.model"/>
		<property name="mapperLocations" value="classpath:mapper/*.xml"/>
	</bean>
```

- 이것 또한 bean을 통해 관리가 가능하다.
- 스프링에서 sqlSessionFactory Bean을 관리
    - `<property name="mapperLocations" value="classpath:mapper/*.xml"/>`
- mapper scanner로 사용하는 방법

```jsx
<mybatis-spring:scan base-package="com.ssafy.*.model.mapper"/>
```

```jsx
@Mapper
public interface BoardMapper {

	void writeArticle(BoardDto boardDto) throws SQLException;

	void registerFile(BoardDto boardDto) throws Exception;

	List<BoardDto> listArticle(Map<String, Object> param) throws SQLException;
}
```

- 이로써 코드의 단축이 이루어졌다…
