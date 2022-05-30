<%-- <!-- <%-- only sample purpose --%>
<%-- <%@ include file="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp" %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Employee Register page</title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/member/register.css">

        </head>

        <body>
            <div class="Employee-Form col-8 ml-a mr-a">
                <div class="text-left">Welcome to my team . We have 2 admins included Le Hoang Loc and Nguyen Thai Hung </div>
                <!-- <%-- <div><p>${pageContext.request.contextPath}</p></div> --%> -->
                <form action="<%=request.getContextPath()%>/member/sign-up/confirm" method="POST" id="registerForm">
                    <input type="hidden" name="action" value="submit">

                    <div class="form-row mt-4 align-center justify-content-center">
                        <div class="col-md-3">
                            <label for="first_name">First name</label>
                            <input id="first_name" name="firstName" type="text"  class="form-control" required placeholder="Your first name">
                        </div>
                        <div class="col-md-3">
                            <label for="last_name">Last name</label>
                            <input id="last_name" name="lastName" type="text" class="form-control" required placeholder="Your last name">
                        </div>
                        <div class="col-md-2">
                            <label class="my-1 mr-2" for="gentle">Gentle</label>
                            <select name="gentle" class="custom-select my-1 mr-sm-2" id="gentle">
                            <option selected>Choose...</option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="other">other...</option>
                    </select>
                        </div>
                    </div>
                    <div class="form-row mt-4 flex-column align-center">
                        <div class="col-md-8 justify-content-center">
                            <label for="user_name">Username</label>
                            <input id="user_name" name="username" type="text" class="form-control" required placeholder="Your username">
                        </div>
                        <div class="col-md-8">
                            <label for="password">Password</label>
                            <input id="Password" name="password" type="password" class="form-control" required placeholder="Your password">
                        </div>
                    </div>
                    <div class="form-row mt-4 flex-column align-center">
                        <div class="col-md-8">
                            <label for="address">Email</label>
                            <input id="address" name="email" type="email" class="form-control" placeholder="Your Email">
                        </div>
                        <div class="col-md-8">
                            <label for="contact">Contact</label>
                            <input id="contact" name="contact" type="text" class="form-control" placeholder="Your contact info">
                        </div>
                    </div>
                    <div class="button-submit">
                        <div class="form-row  submit-block">
                            <div class="">
                                <button type="submit" form="registerForm" class="form-button btn btn-success mt-4 signup-bt">Register</button>
                            </div>
                        </div>
                        <div class="form-row submit-block">
                            <div class="">
                                <a href="${pageContext.request.contextPath}/" style ="visibility: hidden" class="form-button btn btn-secondary mt-4 cancel-bt">Cancel</a>
                            </div>
                        </div>
                    </div>
                    <!-- New -->
                    <div class="form-row flex-column align-center">
                        <div class="col-md-8">
                            <div class="mb__dk">
                                <button type="submit" form="registerForm" class="form-button btn btn-success mt-4 signup-bt">Register</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
    <%-- <c:import url="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp" /> --%>
    <%-- <jsp:include page="<%=request.getContextPath()%>/WEB-INF/views/common/footer.jsp" /> --%>
            <!-- confirm modal -->
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
            <script>
            console.log("register")
                const listRow = document.querySelectorAll(".form-row");
                window.addEventListener("resize", (e) => {
                    let width = window.innerWidth;
                    listRow.forEach((v, i) => {
                        if (width <= 768) {
                            if (v.classList.contains("mt-4")) {
                                v.classList.remove("mt-4");
                            }
                        } else {
                            if (!v.classList.contains("mt-4")) {
                                v.classList.add("mt-4");
                            }
                        }
                    });
                }); 
            </script>
        </body>

        </html>