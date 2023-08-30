@import exercise.dto.users.UsersPage
@param UsersPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>User List</h1>
    <form action="/users" method="get" class="mb-3">
        <div class="input-group">
            <input type="text" class="form-control" name="term" value="${page.getTerm()}" placeholder="Search by first name">
            <button class="btn btn-primary" type="submit">Search</button>
        </div>
    </form>
        <table class="table table-striped">
            @for(var user : page.getUsers())
                <tr>
                    <td>
                        ${user.getId()}
                    </td>
                        <td>
                            <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
                        </td>
                </tr>
            @endfor
        </table>
</div>
</body>
</html>
