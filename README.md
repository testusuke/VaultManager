# VaultManager
  
## Vaultの依存関係へ追加
Gradle(build.gradle)  
```groovy
repositories {
    maven {
        url = uri("https://jitpack.io")
    }
}

dependencies {
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
}
```  
Maven(pom.xml)  
```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.github.MilkBowl</groupId>
        <artifactId>VaultAPI</artifactId>
        <version>1.7</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```  
  
## メインクラスでVaultManagerを定義してインスタンスを作成  
```kotlin
    companion object{
        //  vaultManager
        lateinit var vaultManager: VaultManager
    }
    override fun onEnable() {
        //  VaultManager
        vaultManager = VaultManager(this)
    }
```  
## Vaultを使用してみる。  
- 残高確認
```kotlin
vaultManager.economy?.getBalance(Player)
```
- 引き出し
```kotlin
vaultManager.economy?.withdrawPlayer(Player, Double)
```
- 入金
```kotlin
vaultManager.economy?.depositPlayer(Player, Double)
```

