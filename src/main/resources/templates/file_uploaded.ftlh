<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        .file-container {
            margin-bottom: 20px;
            border: 1px solid #ccc;
            padding: 10px;
        }
        .file-container img {
            max-width: 200px;
            max-height: 200px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h1>Uploaded Files</h1>
<#list files as file>
    <div class="file-container">
        <h2>File Name: ${file.originalFileName}</h2>
        <p>Description: ${file.description}</p>
        <p>Likes: ${file.likes}</p>
        <img src="/files/${file.storageFileName}" alt="${file.originalFileName}">
    </div>
</#list>
</body>
</html>