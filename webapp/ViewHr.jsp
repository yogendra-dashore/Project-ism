<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Hr</title>

</head>
<body>
              <a href="HrListController">Back</a>
     <h2>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; Hr Details</h2>
    <pre><h2>
    HrId    :- ${hrBean.id};
    HrName  :- ${hrBean.hrname};
    HrEmail :- ${hrBean.hremail};
    HrPass  :- ${hrBean.hrpassword};
    HrMobno :- ${hrBean.hrmobno};
    </h2></pre>
</body>
</html>