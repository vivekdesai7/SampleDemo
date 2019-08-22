package com.example.smapledemo.Model



    class UserModel {
        var login = ""
        var id = ""
        var node_id = ""
        var avatar_url = ""
        var gravatar_id = ""
        var url = ""
        var html_url = ""

        constructor(
            login: String,
            id: String,
            node_id: String,
            avatar_url: String,
            gravatar_id: String,
            url: String,
            html_url: String
        ) {
            this.login = login
            this.id = id
            this.node_id = node_id
            this.avatar_url = avatar_url
            this.gravatar_id = gravatar_id
            this.url = url
            this.html_url = html_url
        }
    }