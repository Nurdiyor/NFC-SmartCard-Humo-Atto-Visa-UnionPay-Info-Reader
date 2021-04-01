/* NFC Reader is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 3 of the License, or
(at your option) any later version.

NFC Reader is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Wget.  If not, see <http://www.gnu.org/licenses/>.

Additional permission under GNU GPL version 3 section 7 */

package uz.micro.star.humo_atto_visa_union_pay_nfc_info_reader.nfc;

import android.app.Application;

import java.lang.Thread.UncaughtExceptionHandler;


public final class NfcReaderApplication extends Application implements
        UncaughtExceptionHandler {
    private static NfcReaderApplication instance;

    public static String getStringResource(int resId) {
        return instance.getString(resId);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        System.exit(0);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Thread.setDefaultUncaughtExceptionHandler(this);

        instance = this;
    }

}
