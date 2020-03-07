pipeline {
    // 指定集群 any 表示所有
    agent any

    // 工具
    tools {
        maven 'maven'
        jdk 'openjdk'
    }

    // 定义常量
    environment {

        dingTalkUrl = '钉钉通知地址'

        // 开始logo
        imageOfStart = 'https://www.easyicon.net/api/resizeApi.php?id=1229977&size=128'

        // 成功logo
        imageOfSuccess = 'https://www.easyicon.net/api/resizeApi.php?id=1194837&size=128'

        // 失败logo
        imageOfFailure = 'https://www.easyicon.net/api/resizeApi.php?id=1201052&size=128'

        // 不稳定logo
        imageOfUnstable = 'https://www.easyicon.net/api/resizeApi.php?id=1219854&size=128'

        // 终止logo
        imageOfAborted = 'https://www.easyicon.net/api/resizeApi.php?id=1183198&size=128'

        // 通知人
        notifyPeople = '通知人电话号码'

        // 认证Id
        credentialsId = 'd9e49f50-f989-48d7-96b2-cd9f3cdc7f4f'

        // 仓库地址
        repositoryUrl = 'https://gitee.com/huangxunhui/basic_project.git'

        // 打包命令
        mavenProd = 'mvn clean package -P prod -Dmaven.test.skip=true'
        mavenQuasi = 'mvn clean package -P pre -Dmaven.test.skip=true'
        mavenTest = 'mvn clean package -P test -Dmaven.test.skip=true'
        mavenDev = 'mvn clean package -P dev -Dmaven.test.skip=true'

        // sshPublisher 配置
        removePrefix = '/target'
        remoteDirectory = 'BasicProject'
        sourceFiles = 'target/BasicProject.jar'

        execCommandQuasi = 'cd /mnt/webserver &&  ./manage.sh BasicProject stop && ./manage.sh BasicProject start '
        execCommandTest = 'cd /resources/webserver && ./manage.sh BasicProject stop && ./manage.sh BasicProject start'
        execCommandDev = 'sh /resources/sh/CDnew.sh 10.0.0.32 /resources/local/webserver/BasicProject jar BasicProject'

    }

    stages {

        stage('开始构建通知'){
            steps {
                dingTalk accessToken: "${dingTalkUrl}", imageUrl: "${imageOfStart}", jenkinsUrl: "${env.JENKINS_URL}", message: '开始构建', notifyPeople: "${notifyPeople}"
            }
        }

        stage('拉取代码'){
            steps {
                echo "拉取 ${BRANCH_NAME} 分支的代码。"
                checkout([$class: 'GitSCM', branches: [[name: "*/${BRANCH_NAME}"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "${credentialsId}", url: "${repositoryUrl}"]]])
            }
        }

        stage('进行打包'){
            steps {
                script {
                    if (env.BRANCH_NAME == 'dev') {
                        sh "${mavenDev}"
                    } else if (env.BRANCH_NAME == 'test') {
                        sh "${mavenTest}"
                    } else if (env.BRANCH_NAME == 'pre') {
                        sh "${mavenQuasi}"
                    } else {
                        sh "${mavenTest}"
                    }
                }
            }
        }

        stage('项目部署'){
            steps {
                script {
                    if (env.BRANCH_NAME == 'dev') {
                        // 部署开发环境
                        sshPublisher(publishers: [sshPublisherDesc(configName: '开发环境', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: "${execCommandDev}", execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory:  "${remoteDirectory}", remoteDirectorySDF: false, removePrefix: "${removePrefix}", sourceFiles: "${sourceFiles}")], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
                    } else if (env.BRANCH_NAME == 'test') {
                        sshPublisher(publishers: [sshPublisherDesc(configName: '测试环境', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: "${execCommandTest}", execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory:  "${remoteDirectory}", remoteDirectorySDF: false, removePrefix: "${removePrefix}", sourceFiles: "${sourceFiles}")], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
                    } else if (env.BRANCH_NAME == 'pre') {
                        sshPublisher(publishers: [sshPublisherDesc(configName: '准生产环境', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: "${execCommandQuasi}" , execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: "${remoteDirectory}", remoteDirectorySDF: false, removePrefix: "${removePrefix}", sourceFiles: "${sourceFiles}")], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
                    } else {
                        sshPublisher(publishers: [sshPublisherDesc(configName: '开发环境', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: "${execCommandTest}", execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory:  "${remoteDirectory}", remoteDirectorySDF: false, removePrefix: "${removePrefix}", sourceFiles: "${sourceFiles}")], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
                    }
                }
            }
        }
    }

    // 流水线结束通知
    post {

        // 成功通知
        success {
            dingTalk accessToken: "${dingTalkUrl}" , imageUrl: "${imageOfSuccess}", jenkinsUrl: "${env.JENKINS_URL}", message: '构建成功', notifyPeople: "${notifyPeople}"
        }

        // 失败通知
        failure {
            dingTalk accessToken: "${dingTalkUrl}", imageUrl: "${imageOfFailure}", jenkinsUrl: "${env.JENKINS_URL}", message: '构建失败', notifyPeople: "${notifyPeople}"
        }

        // 构建不稳定通知
        unstable {
            dingTalk accessToken: "${dingTalkUrl}", imageUrl: "${imageOfUnstable}", jenkinsUrl: "${env.JENKINS_URL}", message: '构建不稳定', notifyPeople: "${notifyPeople}"
        }

        // 构建终止通知
        aborted {
            dingTalk accessToken: "${dingTalkUrl}", imageUrl: "${imageOfAborted}", jenkinsUrl: "${env.JENKINS_URL}", message: '构建终止', notifyPeople: "${notifyPeople}"
        }
    }
}