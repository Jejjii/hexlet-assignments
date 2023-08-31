<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body class="d-flex align-items-center justify-content-center" style="min-height: 100vh">
<form action="/users" method="post" class="border p-4 rounded shadow-lg" style="width: 400px;">
    <div class="mb-3">
        <label for="firstName" class="form-label">Имя</label>
        <input type="text" name="firstName" class="form-control" id="firstName">
    </div>
    <div class="mb-3">
        <label for="secondName" class="form-label">Фамилия</label>
        <input type="text" name="secondName" class="form-control" id="secondName">
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" required name="email" class="form-control" id="email">
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Пароль</label>
        <input type="password" required name="password" class="form-control" id="password">
    </div>
    <div class="mb-3">
        <label for="passwordConfirmation" class="form-label">Подтверждение пароля</label>
        <input type="password" required name="passwordConfirmation" class="form-control" id="passwordConfirmation">
    </div>
    <button type="submit" class="btn btn-primary">Зарегистрировать</button>
</form>
</body>
</html>
