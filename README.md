
FishChatServerJava
======

FishChatServer的Java版本

FAQ
======
##### 为什么要用Java重写
其一,  golang语言目前普及度不高, Java版本更方便和更多的朋友交流

其二,  并非是单纯的纯写, 也考虑了之前细节上的不妥之处


##### 网络库为什么要用Netty
其一,  分包、编解码、Buffer等等这些东西, 我已经轮了无数次了, 实在不想再造轮子了, Netty具有API优雅的各类实现(我见过实现最漂亮的)

其二,  之前在Nginx里面被NIO坑了无数次, Java的NIO也是有坑, Netty修复了这些坑

##### 两个版本怎么维护
同时进行维护


##### 测试
暂时可以用golang版的客户端测试: https://github.com/oikomi/FishChatServer/tree/master/client



Copyright & License
===================

Copyright 2015 Hong Miao (miaohong@miaohong.org). All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

