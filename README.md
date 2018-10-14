# spring-boot-auth-server

**Oauth2:**
Oauth2 is version 2 of the OAuth protocol. This protocol allows third party applications to grand limited access to third party applications on behalf of resource owner. 

**OAuth2 Roles**: There are four roles that can be applied on OAuth2

**Resource Owner**: The owner of the resource — for example you have account in google. Your profile data resides with google. You are owner of that data. 

**Resource Server:** The application or server which is hosting resource. This could be http service, RESTful Webservice and so on. For example google has service to expose user details as service. This service resides in resource server. 

**Client**: The application requiring access to the resource ownner's resource on the resource server. For example you are resource owner trying to logged in to youtube using your google account. Here youtube is a client program need to use your google account details to allow you to use youtube features. 
  	
**Authorization Server:**  The single place to perform authorization of resource owner. First client application has to register itself with Authorization server so that the server can identify request is coming from registered client. Next step is to authenticate resouce owner with given credentials. If the credentials are correct a bearer token is issued by this server to the client in response.This token can later be used to access other resouce or service from resource server.

**Tech stack :**
 - Spring boot-1.5.8 	
 - Mysql 	
 - Oauth2 	
 - Spring-data-jpa

**Project:** This sample project is used to provide authorization server functionality using oauth2 protocol. Spring boot has provided built in annotations to facilitate creating authorization and resource server. Real time use case of creating auth server is   when you want to implement **single sign on** [SSO]. Resource server and auth server both are part of the same auth-server project.

**SSO:**
As a user you will need to access different applications on daily basis. You do not want to create accounts in each of these application and remember username and password for each. Instead you want to create single account and allow other application to use that account as base account.
SSO avoids the monotonous task of confirming identity over and over again through passwords or other authentication systems

**Endpoints :**

auth server is running on port 8081 and context-path is /auth so corresponding end points are
      
      accessTokenUri: http://localhost:8081/auth/oauth/token
      userAuthorizationUri: http://localhost:8081/auth/oauth/authorize
      userInfoUri: http://localhost:8081/auth/rest/hello/principal

**Grant Type :**
Project uses authorization_code grant type to see further details on grant types refer  https://oauth.net/2/grant-types/

**auth-client :** 
Client project which is using auth-server to get access to sample REST service. The project is running on port 8082. context-path is /ui.

**Database :**
There are three tables used to provide authentication.
User : user table stores user information like email and password.
Role : provides user role
user-role : mapping table between user and role.

**Screens**

Home page

![enter image description here](https://lh3.googleusercontent.com/aoxvK3ginj9GkLkpkO2_MgAGACdNMkrMxmn3vwxsg0PMPD0DgDi74WVqXqYg0Lzl8q4ft92XkCwG "login success")

Login


![enter image description here](https://lh3.googleusercontent.com/2kK7lkwQpOk9rwfr6i2siFwTRzdWPwJSbNnwqDIwq1I61y771Sp8c_8FIybdHT11-A5OBEX_QzMj "login")


login success

![enter image description here](https://lh3.googleusercontent.com/tPhOF2UGfb5TNLotj3nw4R7WxNeE4B8NG8a5t3T-4c2597cgsxSPB1E6NGzqhcu9vgSSHxnIoN_p "auth-client")

