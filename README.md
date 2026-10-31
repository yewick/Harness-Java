# yewick-harness-java

**DeepSeek Harness Java** —— 基于 DDD 六边形架构的 Agent Harness。

## 项目简介

本项目采用 DDD（领域驱动设计）六边形（端口与适配器）架构，将 Agent Harness 的核心业务
与技术细节解耦，通过清晰的模块边界保证领域层的独立性与可测试性。

## 模块划分

| 模块 | 层级 | 职责 |
| --- | --- | --- |
| `yewick-harness-types` | 类型层 | 跨层共享的基础领域对象模型（消息、工具等） |
| `yewick-harness-api` | 接口契约层 | 对外暴露的接口与 DTO 定义（端口契约） |
| `yewick-harness-domain` | 领域层 | 核心业务实体、领域服务与仓储端口 |
| `yewick-harness-infrastructure` | 基础设施层 | 仓储实现、网关适配、配置与外部服务访问 |
| `yewick-harness-app` | 应用层 | 应用服务编排与用例组装 |
| `yewick-harness-trigger` | 触发器层 | HTTP / RPC / 事件监听等外部入口 |
| `yewick-harness-start` | 启动装配层 | 应用装配与启动入口 |

## 依赖方向

```
trigger ──▶ app ──▶ domain ──▶ types
    │          │
    │          └──────▶ api ──▶ types
    │
    └──▶ api ──▶ types

infrastructure ──▶ domain / api / types
start ──▶ trigger / app / infrastructure
```

依赖始终由外层指向内层（领域核心），符合六边形架构「依赖倒置」的原则。

## 技术栈

- Java 17
- Spring Boot 3.3.x
- Maven 多模块
- Lombok

## 快速开始

```bash
mvn clean install
mvn -pl yewick-harness-start spring-boot:run
```

## 许可

该项目仅为学习用途的工程骨架。
