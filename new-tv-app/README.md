# TV Mobile - Android TV应用

一个类似TV仓库的Android Mobile应用，支持视频播放、直播、搜索等功能。

## 功能特点

- 📺 视频点播 - 展示和管理视频内容
- 📡 直播频道 - 支持直播源播放
- 🔍 视频搜索 - 快速搜索视频内容
- ⚙️ 设置管理 - 灵活的应用配置
- 🎬 视频播放 - 基于ExoPlayer的视频播放器
- 🐍 Python脚本支持 - 使用Chaquopy运行Python爬虫
- 📜 JavaScript脚本支持 - 使用QuickJS运行JS爬虫

## 技术栈

- **语言**: Java 17
- **UI**: Material Design Components
- **数据库**: Room
- **网络**: OkHttp
- **视频播放**: ExoPlayer (Media3)
- **脚本解析**: QuickJS, Chaquopy
- **爬虫框架**: CatVOD

## 项目结构

```
app/                    # 主应用模块
├── bean/              # 数据实体类
├── db/                # Room数据库
├── event/             # EventBus事件
├── service/           # 后台服务
├── ui/                # UI组件
│   ├── activity/      # Activity
│   ├── adapter/       # RecyclerView适配器
│   └── fragment/      # Fragment
└── utils/             # 工具类

catvod/                # 爬虫基础库
├── bean/             # 数据Bean
├── crawler/          # 爬虫基类
├── net/              # 网络请求
└── utils/            # 工具类

quickjs/               # JavaScript脚本支持
├── bean/             # 请求响应Bean
├── crawler/          # JS爬虫实现
├── method/           # JS全局方法
└── utils/            # 工具类

chaquo/                # Python脚本支持
├── java/             # Java接口
└── python/           # Python脚本
```

## 环境要求

- Android Studio Hedgehog (2023.1.1) 或更高版本
- JDK 17 或更高版本
- Android SDK 34
- Gradle 8.7

## 快速开始

### 1. 克隆项目
```bash
git clone <repository-url>
cd new-tv-app
```

### 2. 配置Android SDK
确保在 `local.properties` 文件中配置了Android SDK路径：
```properties
sdk.dir=/path/to/your/android/sdk
```

### 3. 构建项目
```bash
# 使用Gradle Wrapper
./gradlew assembleDebug

# 或者使用Android Studio
# 打开项目 -> Build -> Make Project
```

### 4. 安装应用
```bash
# 通过ADB安装
adb install app/build/outputs/apk/mobile/debug/mobile-debug.apk

# 或者直接通过Android Studio运行到设备
# Run -> Run 'app'
```

## 构建变体

项目支持以下构建变体：

- **mobile-debug**: Mobile模式Debug版本
- **mobile-release**: Mobile模式Release版本

## 添加爬虫源

1. 在 `app/src/main/assets/` 目录下添加爬虫配置文件
2. 配置JSON格式的站点信息
3. 可选：添加JavaScript或Python爬虫脚本

## 自定义配置

在 `Constant.java` 中修改常量值来自定义应用行为：
- 超时时间
- 缓存策略
- 播放设置

## 许可证

本项目仅供学习和研究使用。

## 贡献

欢迎提交Issue和Pull Request！
