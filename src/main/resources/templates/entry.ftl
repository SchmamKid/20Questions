<!DOCTYPE html>
<html lang="en">
<head>
    <title>Kotlin Journal</title>
</head>
<p>

    YOU SUBMITTED IT
</p>

<#list entries as item>
<div>
    <h3>${item.headline}</h3>
    <p>${item.body}</p>
</div>
</#list>