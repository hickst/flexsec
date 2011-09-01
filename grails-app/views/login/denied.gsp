<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Access Denied</title>
  </head>

  <body>
    <div class="body">
      <div class="errors"><ul><li>${flash.infoMsg}</li></ul></div>

      <h2>Access Denied:</h2>
      <div class="footnote">
        <ul>
          <li>
            You are currently logged in as user id
            '<sec:loggedInUserInfo field="username" />'.
            That user is not allowed to view the requested page.
          </li>
          <li>
            If you are running the FlexSec application in
            another tab or window, you can just close this window.
          </li>
          <li>
            Otherwise, you can click <g:link controller="logout">LOGOUT</g:link>
            to logout '<sec:loggedInUserInfo field="username"/>' and login
            as another user.
          </li>
        </ul>
      </div> <!-- footnote -->

    </div> <!-- body -->
  </body>
</html>
