# yewick-harness-java

**DeepSeek Harness Java** —— 基于 DDD 六边形架构的 Agent Harness。

## 项目简介

本项目采用 DDD（领域驱动设计）六边形（端口与适配器）架构，将 Agent Harness 的核心业务
与技术细节解耦，通过清晰的模块边界保证领域层的独立性与可测试性。

## 模块划分

| 模块 | 层级 | 职责 |
| --- | --- | --- |
| `yewick-harness-types` | 类型层 | 共享类型与插件 SPI 契约：消息/工具模型、插件生命周期契约。不依赖任何内部模块 |
| `yewick-harness-api` | 接口契约层 | 对外 API 契约：接口、DTO、统一返回体、SSE 流式契约。不依赖任何内部模块 |
| `yewick-harness-domain` | 领域层 | 端口（Port）定义与领域服务。六边形架构的内核，只依赖 types |
| `yewick-harness-infrastructure` | 基础设施层 | 适配器层：domain 端口的基础设施实现（持久化、LLM 适配、工具执行、插件加载等） |
| `yewick-harness-case` | 用例编排层 | 策略树骨架与各业务用例流水线，串联 domain 能力响应 api 契约 |
| `yewick-harness-trigger` | 触发器层 | 触发层：HTTP Controller、SSE 推送、鉴权拦截——外部请求进入系统的入口 |
| `yewick-harness-app` | 启动装配层 | 唯一可启动模块，聚合 trigger + infrastructure，承载配置与启动 Runner |

## 依赖方向

```
app ──▶ trigger ──▶ api
 │         ├──▶ case ──▶ domain ──▶ types
 │         │        └──▶ api
 │         └──▶ infrastructure ──▶ domain ──▶ types
 └──▶ infrastructure
```

依赖始终由外层指向内层（领域核心），符合六边形架构「依赖倒置」的原则。

## 技术栈

- Java 17
- Spring Boot 3.3.2
- Maven 多模块

## 快速开始

```bash
mvn clean install
mvn -pl yewick-harness-app spring-boot:run
```

## 许可

该项目仅为学习用途的工程骨架。
