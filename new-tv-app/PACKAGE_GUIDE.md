# 手机应用打包指南

## 📱 APK打包详细步骤

### 方式一：使用Android Studio（推荐新手）

#### 1. 准备工作
确保已安装：
- Android Studio Hedgehog (2023.1.1) 或更高版本
- JDK 17 或更高版本
- Android SDK 34

#### 2. 用Android Studio打开项目
```
1. 打开Android Studio
2. 选择 "Open an existing project"
3. 浏览到 new-tv-app 文件夹
4. 点击 "OK"
```

#### 3. 配置本地SDK路径
在项目根目录创建 `local.properties` 文件：
```properties
sdk.dir=/Users/你的用户名/Library/Android/sdk
# Windows示例: sdk.dir=C\:\\Users\\你的用户名\\AppData\\Local\\Android\\Sdk
# Linux示例: sdk.dir=/home/你的用户名/Android/Sdk
```

#### 4. 同步Gradle
```
1. 点击顶部菜单 "File" -> "Sync Project with Gradle Files"
2. 等待同步完成（约5-10分钟）
```

#### 5. 构建Debug APK
```
1. 点击右侧 "Gradle" 工具窗口
2. 展开 app -> Tasks -> build
3. 双击 "assembleDebug"
4. 等待构建完成
```

或在终端执行：
```bash
cd new-tv-app
./gradlew assembleDebug
```

#### 6. 找到APK文件
```
APK位置：app/build/outputs/apk/mobile/debug/mobile-debug.apk
```

---

### 方式二：使用命令行打包

#### 1. 确保已安装Java和Gradle

检查Java版本：
```bash
java -version
# 应该显示 Java 17 或更高版本
```

如果没有Gradle，在项目中已有gradlew wrapper，无需单独安装。

#### 2. 执行构建命令

```bash
# 进入项目目录
cd new-tv-app

# 给gradlew添加执行权限（仅Unix系统需要）
chmod +x gradlew

# 构建Debug版本
./gradlew assembleDebug

# 构建Release版本（需要签名配置）
./gradlew assembleRelease
```

#### 3. APK输出位置
```
new-tv-app/app/build/outputs/apk/mobile/debug/mobile-debug.apk
```

---

## 📲 安装到手机

### 方法1：直接传输APK文件

1. 将APK文件复制到手机存储
2. 打开手机文件管理器
3. 点击APK文件开始安装
4. 如果提示"未知来源"，需要开启安装权限：
   - 设置 -> 安全 -> 开启"未知来源"
   - 或设置 -> 应用 -> 找到文件管理器 -> 开启"安装未知应用"

### 方法2：使用ADB安装

1. 开启手机开发者选项和USB调试：
   ```
   设置 -> 关于手机 -> 点击"版本号"7次
   设置 -> 开发者选项 -> 开启"USB调试"
   ```

2. 用USB线连接手机到电脑

3. 安装APK：
   ```bash
   # 查看已连接的设备
   adb devices
   
   # 安装APK
   adb install app/build/outputs/apk/mobile/debug/mobile-debug.apk
   
   # 如果已安装，使用 -r 参数重新安装
   adb install -r app/build/outputs/apk/mobile/debug/mobile-debug.apk
   ```

### 方法3：局域网无线安装

1. 先用USB连接，执行：
   ```bash
   adb tcpip 5555
   ```

2. 断开USB连接

3. 获取手机IP地址：
   ```
   设置 -> WLAN -> 点击已连接的网络 -> IP地址
   ```

4. 无线连接并安装：
   ```bash
   adb connect 手机IP地址:5555
   adb install app/build/outputs/apk/mobile/debug/mobile-debug.apk
   ```

---

## ⚙️ Release版本打包（可选）

Release版本需要签名配置。在 `app/build.gradle` 中添加：

```gradle
android {
    signingConfigs {
        release {
            storeFile file("your-keystore.jks")  // 密钥库文件
            storePassword "your-store-password"
            keyAlias "your-key-alias"
            keyPassword "your-key-password"
        }
    }
    
    buildTypes {
        release {
            signingConfig signingConfigs.release
            minifyEnabled true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}
```

构建Release版本：
```bash
./gradlew assembleRelease
```

---

## 🐛 常见问题

### Q1: Gradle同步失败
```
解决方案：
1. 检查网络连接
2. 清理缓存：./gradlew clean
3. 重新同步：File -> Invalidate Caches -> Restart
```

### Q2: 找不到SDK
```
解决方案：
1. 确保local.properties中sdk.dir路径正确
2. 检查SDK是否正确安装
3. 在Android Studio中配置：File -> Project Structure -> SDK Location
```

### Q3: 构建超时
```
解决方案：
1. 增加Gradle内存：在 gradle.properties 中添加
   org.gradle.jvmargs=-Xmx4096m -XX:MaxMetaspaceSize=1024m
2. 使用国内镜像：在 build.gradle 中添加
   maven { url 'https://maven.aliyun.com/repository/public' }
```

### Q4: 手机无法安装
```
解决方案：
1. 确认APK版本与手机Android版本兼容
2. 开启"未知来源"安装权限
3. 检查手机存储空间是否充足
4. 尝试清理手机缓存
```

---

## 📦 获取完整的APK

构建完成后，APK文件位于：
```
new-tv-app/app/build/outputs/apk/mobile/debug/mobile-debug.apk
```

可以直接将这个APK文件分享给其他人安装使用！

---

## 🔧 开发调试

开启USB调试后，可以使用以下命令查看日志：
```bash
# 实时查看应用日志
adb logcat -c && adb logcat | grep com.fongmi.android.tv

# 查看崩溃日志
adb logcat | grep -i exception
```

---

祝你打包成功！🎉
