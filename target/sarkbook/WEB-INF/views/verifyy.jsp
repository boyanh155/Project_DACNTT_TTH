  <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/member/verify.css">
        <title>Verify Page</title>
    </head>
    <!-- <body>
        <span>We already send a verification  code to your email.</span>  
        <form action="<%=request.getContextPath()%>/member/sign-up/verify_confirm"  method="POST" id="verify">
            <input type="text" name="authcode" >
            <input type="submit" value="verify" form="verify">
        </form>
    </body> -->
    <body>
        <table class="email-wrapper" width="100%" cellpadding="0" cellspacing="0">
          <tr>
            <td align="center">
              <table class="email-content" width="100%" cellpadding="0" cellspacing="0">
                <!-- Logo -->
                <tr>
                  <td class="email-masthead">
                    <a class="email-masthead_name">SARK</a>
                  </td>
                </tr>
                <!-- Email Body -->
                <tr>
                  <td class="email-body" width="100%">
                    <table class="email-body_inner" align="center" width="570" cellpadding="0" cellspacing="0">
                      <!-- Body content -->
                      <tr>
                        <td class="content-cell">
                          <p>Thanks for signing up for SARK! .</p>
                          <h1>Verify your email address</h1>
                          <h1>We already send a verification  code to your email.</h1>
                          <!-- Action -->
                          <table class="body-action" align="center" width="100%" cellpadding="0" cellspacing="0">
                            <tr>
                              <td align="center">
                                <div>
                                    <form action="<%=request.getContextPath()%>/member/sign-up/verify_confirm"  method="POST" id="verify">
                                        <input type="text" name="authcode" value="" >
                                        <br>
                                        <input type="submit"  class="button button--black" value="Verify Email" form="verify">
                                    </form>
                                </div>
                              </td>
                            </tr>
                          </table>
                          <p>Thanks,<br>The SARK Team</p>
                          <!-- Sub copy -->
                          <!-- <table class="body-sub">
                            <tr>
                              <td>
                                <p class="sub">If you’re having trouble clicking the button, copy and paste the URL below into your web browser.
                                </p>
                                <p class="sub"><a href="{{action_url}}">{{action_url}}</a></p>
                              </td>
                            </tr>
                          </table> -->
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
                <tr>
                  <td>
                    <table class="email-footer" align="center" width="570" cellpadding="0" cellspacing="0">
                      <tr>
                        <td class="content-cell">
                          <p class="sub center">
                            SARK Lab, K19.
                            <br>HCM University of Technology and Education
                          </p>
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
        </table>
      </body>
</html>