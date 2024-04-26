<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"></script>
    <title>Document</title>
    <script>
        function increaseLikes() {
            let likesCount = parseInt(document.getElementById("likesCount").innerText);
            likesCount++;
            document.getElementById("likesCount").innerText = likesCount;
        }

        function sendFile() {
            let description = document.getElementById("description").value;
            let likesCount = parseInt(document.getElementById("likesCount").innerText);

            // данные для отправки
            let formData = new FormData();
            // забрал файл из input
            let files = ($('#file'))[0]['files'];
            // добавляю файл в formData
            [].forEach.call(files, function (file, i, files) {
                formData.append("file", file);
            });

            formData.append("description", description);
            formData.append("likes", likesCount)

            $.ajax({
                type: "POST",
                url: "/files",
                data: formData,
                processData: false,
                contentType: false
            })
                .done(function (response) {
                    let fileUrl = 'http://localhost:8080/files/' + response;
                    $('#photo').append('<img src = "' + fileUrl + '"/>');

                    //reincio el contador desde cero
                    document.getElementById("likesCount").innerText = "0";
                })
                .fail(function () {
                    alert('Error')
                });
        }
    </script>
</head>
<body>
<div>
    <input type="file" id="file" name="file" placeholder="Имя файла..."/>
    <input type="hidden" id="file_hidden">
    <textarea id="description" placeholder="Add description"></textarea> <
    <button onclick="increaseLikes()">Like</button>
    <button onclick="sendFile()">
        Загрузить файл
    </button>
    <div class="filename"></div>
</div>
<div id="photo">
</div>
<div id="likesCount" style="display: none;">0</div>
</body>
</html>