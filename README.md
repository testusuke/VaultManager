# VaultManager
  
## Vaultの依存関係へ追加
Gradle(build.gradle)  
```$xslt
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
```$xslt
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
```$xslt
    companion object{
        //  vaultManager
        lateinit var vaultManager:VaultManager
    }
    override fun onEnable() {
        //  VaultManager
        vaultManager = VaultManager(this)
    }
```  
## Vaultを使用してみる。  
残高確認  
vaultManager.economy?.getBalance(player)  
引き出し  
vaultManager.economy?.withdrawPlayer(player,double)  
入金  
vaultManager.economy?.depositPlayer(player,double)  

