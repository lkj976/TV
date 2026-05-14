# GitHub Actions 配置指南

## 自动打包设置

### 方法1：手动创建工作流（推荐）

1. 访问你的GitHub仓库：https://github.com/lkj976/da-wang

2. 点击上方菜单栏的 `Actions`

3. 点击 `Set up a workflow yourself` 或 `New workflow`

4. 删除默认内容，粘贴以下代码：

```yaml
name: Build APK

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]
  workflow_dispatch:

jobs:
  build:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v4
    
    - name: Set up JDK 17
      uses: actions/setup-java@v4
      with:
        java-version: '17'
        distribution: 'temurin'
        cache: gradle
    
    - name: Grant execute permission for gradlew
      run: chmod +x gradlew
    
    - name: Build Debug APK
      run: ./gradlew assembleDebug
    
    - name: Upload Debug APK
      uses: actions/upload-artifact@v4
      with:
        name: TV-Mobile-Debug
        path: app/build/outputs/apk/mobile/debug/*.apk
    
    - name: Build Release APK
      run: ./gradlew assembleRelease
    
    - name: Upload Release APK
      uses: actions/upload-artifact@v4
      with:
        name: TV-Mobile-Release
        path: app/build/outputs/apk/mobile/release/*.apk
```

5. 点击 `Start commit` -> `Commit new file`

### 方法2：更新Token权限（需要重新生成Token）

1. 访问：https://github.com/settings/tokens
2. 找到你的Token或创建新Token
3. 勾选 `workflow` 权限
4. 保存新Token

### 方法3：手动触发构建

在本地运行以下命令构建APK：

```bash
cd new-tv-app
./gradlew assembleDebug
./gradlew assembleRelease
```

APK文件位于：
- Debug: `app/build/outputs/apk/mobile/debug/mobile-debug.apk`
- Release: `app/build/outputs/apk/mobile/release/mobile-release.apk`

---

## 获取构建产物

配置完成后：

1. 每次推送代码到 `main` 分支时，GitHub会自动运行构建
2. 构建完成后，在 `Actions` 页面点击对应的工作流
3. 在页面底部的 `Artifacts` 部分下载APK文件

---

## 手动构建APK

如果你不想使用GitHub Actions，可以直接在本地构建：

```bash
# 构建Debug版本
./gradlew assembleDebug

# 构建Release版本
./gradlew assembleRelease

# 安装到连接的设备
adb install app/build/outputs/apk/mobile/debug/mobile-debug.apk
```
