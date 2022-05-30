<%@ page language="java" 
contentType="text/html;charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/member/edit.css">
</head>

<body>
    <div class="container rounded bg-white mt-5 mb-5">
        <form id="form-user-edit" action="${pageContext.request.contextPath}/editVerify" method="POST">
        <input type="hidden" name="action" value="edit"/>
        <input type="hidden" name="_id" value="${userEdit.id}">
            <div class="row">
                <div class="col-md-3 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <div class="imgArea">
                        </div>
                        <span class="font-weight-bold">${userEdit.firstName} ${userEdit.lastName}</span>
                        <span class="text-black-50">${userEdit.email}</span>
                        <label class="lbFile" for="files">Update avatar</label>
                        <input id="files" type="file" style="visibility:hidden;" onchange="readURL(this)" accept="image/png, image/jpeg">
                    </div>
                </div>
                <div class="col-md-5 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Profile Settings</h4>
                        </div>
                        <div class="row mt-2">
                            <div class="col-md-6"><label class="labels">First Name</label><input  type="text" name="firstName" class="form-control"  value="${userEdit.firstName}"></div>
                            <div class="col-md-6"><label class="labels">Last Name</label><input type="text" name="lastName" class="form-control" value="${userEdit.lastName}"></div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-12"><label class="labels">Address</label><input type="text" name="contact" class="form-control" placeholder="Address" value="${userEdit.contact}"></div>
                            <div class="col-md-12"><label class="labels">Email</label><input type="text" name="email" class="form-control"  placeholder="Email" value="${userEdit.email}"></div>
                        </div>
                        <%-- <div class="mt-5 text-center"><button class="btn btn-primary profile-button" for="form-user-edit" type="submit">Save Profile</button></div> --%>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="p-3 py-5 d-flex flex-column align-items-center">
                        <select name="gentle" class="col-md-12" id="gentle">
                                <option selected>Choose...</option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="other">other...</option>
                        </select>

                        <div class="col-md-12"><label class="">Coming soon</label></div>
                    </div>
                </div>
                    <div class=""><button class="btn btn-primary profile-button" for="form-user-edit" type="submit">Save Profile</button></div>

            </div>
        </form>
    </div>
    </div>
    </div>
    <script>
        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    let img = document.querySelector('.js__img');

                    img.setAttribute('src', e.target.result);
                    img.style = {
                        width: "80px",
                        height: "80px",
                    }
                };
                reader.readAsDataURL(input.files[0]);
            }
        }
    </script>
</body>


</html>