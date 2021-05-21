# NFC-SmartCard-Humo-Atto-Visa-UnionPay-Info-Reader
### NFC Reader is an Android App based on [NFCard](https://github.com/sinpolib/nfcard). It can read contactless IC card use NFC hardware. Support ISO7816-4.It lib read data from cards like HUMO,ATTO,VISA AND UNION PAY 
## allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
## }
  
## dependencies {
	        implementation 'com.github.Nurdiyor:NFC-SmartCard-Humo-Atto-Visa-UnionPay-Info-Reader:0.1.1'
## }

## AndroidManifest.xml
	<activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
            <intent-filter>
                <action android:name="android.nfc.action.TECH_DISCOVERED" />
                <action android:name="android.nfc.action.TAG_DISCOVERED" />
            </intent-filter>

            <meta-data
                android:name="android.nfc.action.TECH_DISCOVERED"
                android:resource="@xml/nfc_tech_filter" />
	</activity>
## android:resource="@xml/nfc_tech_filter"
	<?xml version="1.0" encoding="utf-8"?>
	<resources>
   		 <tech-list>
        		<tech>android.nfc.tech.IsoDep</tech>
       			<tech>android.nfc.tech.NfcF</tech>
   		 </tech-list>
	</resources>
##
