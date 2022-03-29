# Auth-for-Secret-Recipe
### future used:
1- bootstrap with thymeleaf.

2- postgres database manager.

3 - only user log in can show your posts and add new posts for you.

4- only admin can show all information about all user by log in as 
i create admin by default when you run my app but in spring security i will do same thing but by role , to create multiAdmin and set the role admin .

username : `admin`

password : `admin`

![image](https://user-images.githubusercontent.com/97642724/160591073-33cc94d5-9af0-4d5d-860a-0c0ee08bb546.png)

5- if the user login and click in it still in same page until he logs out
### pages
1- Home page just to login and sign up .

2- admin page to show all users information.

3- sign up page to create new user 

4-login page to login 

5- all requirement are done by front end but if you want to test my app by useing postman 

hit this routs : 

1- `/addUserP` it take user by requestBody.

2- `/addPostp` it take posts by requestBody.

### How to run my application
1- replace your port and database url and username and password in application protists.

2- create dataBase` sitedb`

2- go to web and put the path `http://localhost:{your port}/`

you get this page :
![image](https://user-images.githubusercontent.com/97642724/160587977-e99ea65a-f13e-4040-96ea-194da37e210e.png)

to login page

![image](https://user-images.githubusercontent.com/97642724/160589266-6d696c50-b72a-43f2-b720-4b3504914acb.png)
routs :`http://localhost:8081/LoginPage`
## for sign up :
![image](https://user-images.githubusercontent.com/97642724/160589135-776d9cd2-cbca-4204-8bf2-47e7cab10e1e.png)

### project structures :
![image](https://user-images.githubusercontent.com/97642724/160589792-1dd8c7b6-f45e-4216-b25a-0f2514b3cffa.png)
### End points
`http://localhost:8080/` Home page just to login and sign up.

`http://localhost:8080//logOut` it make the session invalid

`http://localhost:8080/LoginPage`  to show login page

`http://localhost:8080/SignPage` to show sign up page

`http://localhost:8080/userPage` to show user posts and add posts for this user

`http://localhost:8080/posts` when the user login you can show all posts 

`http://localhost:8080/AddPosts` it takes post in @ModelAttribute and pot in in data base for user log in

`http://localhost:8080//deletePost/{id}` to delete the posts by id 



