<%@ page defaultCodec="html" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>${title ?: 'News Items'}</title>
  </head>

  <body>
    <div class="nav">
      <span class="menuButton">
        <a class="home" href="${resource(dir:'')}">Home</a>
      </span>
    </div>

    <div class="body">
      <h1>${title ?: 'News Items'}</h1>

      <div class="list">
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Date</th>
              <th>Text</th>
            </tr>
          </thead>
          <tbody>
            <g:each in="${news}" status="i" var="item">
              <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                <td>${fieldValue(bean:item, field:'id')}</td>
                <td>${fieldValue(bean:item, field:'dateCreated')}</td>
                <td>${fieldValue(bean:item, field:'text')}</td>
              </tr>
            </g:each>
          </tbody>
        </table>
      </div>

    </div>
  </body>
</html>
