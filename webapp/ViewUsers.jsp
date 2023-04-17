<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Users</title>
</head>
<body>

<a href="UsersListController">Back</a>
      <pre><h2>
         ID            :- ${resourceBean.id }
         Name          :- ${resourceBean.name };
         Email         :- ${resourceBean.email };
         Mobno         :- ${resourceBean.mobno };
         Experience    :- ${resourceBean.experience };
         ResumeURL     :- ${resourceBean.resumeurl };
         Qualification :- ${resourceBean.qualification };
      </h2></pre>

</body>
</html>