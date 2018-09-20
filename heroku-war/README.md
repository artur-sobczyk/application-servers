# heroku-war

Useful information how to proceed with example.

1. Download heroku CLI: https://devcenter.heroku.com/articles/heroku-cli#download-and-install
2. Register:  https://signup.heroku.com/
3. Login using git bash console


## heroku commands

`heroku help` - lists available options

`heroku login` - login into heroku

`heroku logout` - logout from heroku

`heroku create <app-name>` - creates application in heroku

`heroku logs -a <app-name> --tail` - displays application logs

`heroku war:deploy <path_to_war_file --app <app_name>` - https://devcenter.heroku.com/articles/war-deployment