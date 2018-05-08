# react-native-cloud-image

腾讯云 [万象优图（Cloud Image）](https://www.qcloud.com/product/ci) SDK for React-Native

## 资料

- [腾讯云 sdk 文档](https://cloud.tencent.com/document/product/641/12408)


## 如何安装

### 1. 安装npm包

```
npm install react-native-cloud-image --save
```

### 2. link

#### 自动link方法~rnpm requires node version 4.1 or higher

```
rnpm link react-native-cloud-image
```

link成功后命令会提示如下信息：

```
rnpm info Linking react-native-cloud-image android dependency 
rnpm info Linking react-native-cloud-image ios dependency
```

#### 手动link(如果不能自动link)

**android**

1. 修改项目下 `/android/settings.gradle` 文件

```
// 添加下面代码
include ':react-native-tencent-orc'
project(':react-native-tencent-orc').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-tencent-orc/android')
```

2. 修改项目下 `/android/app/build.gradle` 文件

```
dependencies {
    ...
    compile project(':react-native-tencent-orc')  // 添加这句
}
```

3. 最后修改项目下 `/android/app/src/main/java/com/xxx/MainApplication.java` 文件。

```
// MainApplication.java
import com.reactlibrary.ReactNativeTencentOrcPackage;  // 1.引入包

...
protected List<ReactPackage> getPackages() {
    return Arrays.<ReactPackage>asList(
        new MainReactPackage(),
        new ReactNativeTencentOrcPackage()   // 2.添加这句
    );
}
...
```

**ios**


## 在react native中使用

在 `react-native` 中使用十分简单，只需要像一般组件调用即可。

```
// 1. 引入包
import ReactNativeTencentOrc from 'react-native-tencent-orc'


export default class App extends Components{

    componentDidMount(){

        // 2. 使用
        RNCloudImage.ocrIdCard((res)=>{
            console.log(res)    // 获取省份证信息，String类型
        })

    }
}
```


## 注意事项

1. 电脑模拟器上调试获取不到图像识别的数据，在真机调试没这个问题。

