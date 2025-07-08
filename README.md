# 亚马逊自动化运营平台

这是一个用于亚马逊电商自动化运营的平台，集成了Spring AI功能，可以帮助卖家优化产品描述、分析市场数据等。

## 项目结构

```
├── backend/                # 后端项目
│   ├── src/                # 源代码
│   │   ├── main/
│   │   │   ├── java/      # Java代码
│   │   │   └── resources/ # 配置文件
│   └── pom.xml            # Maven配置
└── frontend/              # 前端项目
    ├── src/               # 源代码
    │   ├── layouts/       # 布局组件
    │   ├── pages/         # 页面组件
    │   ├── App.vue        # 主应用组件
    │   ├── main.js        # 入口文件
    │   ├── router/        # 路由配置
    │   └── store/         # Vuex状态管理
    └── package.json       # NPM配置
```

## 技术栈

### 后端

- Spring Boot 3.2.0
- Spring AI 0.8.0 (集成OpenAI)
- Spring Data JPA
- H2数据库 (开发环境)
- Lombok

### 前端

- Vue.js 3
- Element Plus
- Vue Router
- Vuex
- Axios

## 功能特性

- 产品管理：添加、编辑、删除亚马逊产品
- AI分析：使用Spring AI分析产品数据，提供优化建议
- 描述生成：自动生成优化的产品描述

## 快速开始

### 后端启动

1. 确保已安装Java 17和Maven
2. 配置OpenAI API密钥：
   - 打开 `backend/src/main/resources/application.properties`
   - 设置 `spring.ai.openai.api-key=your-openai-api-key`
3. 在backend目录下运行：
   ```
   mvn spring-boot:run
   ```
4. 后端服务将在 http://localhost:8080 启动

### 前端启动

1. 确保已安装Node.js和npm
2. 在frontend目录下运行：
   ```
   npm install
   npm run serve
   ```
3. 前端应用将在 http://localhost:8081 启动

## 登录信息

- 用户名：admin
- 密码：admin123

## 注意事项

- 这是一个框架项目，尚未实现完整功能
- 需要配置有效的OpenAI API密钥才能使用AI功能
- 当前使用H2内存数据库，重启后数据会丢失