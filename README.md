# NFC-SmartCard-Humo-Atto-Visa-UnionPay-Info-Reader
## allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
## }
  
##  dependencies {
	        implementation 'com.github.Nurdiyor:NFC-SmartCard-Humo-Atto-Visa-UnionPay-Info-Reader:0.1.0'
## }

##
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
	<tech-list>
		<tech>android.nfc.tech.IsoDep</tech>
	</tech-list>
	<tech-list>
		<tech>android.nfc.tech.NfcF</tech>
	</tech-list>
##
