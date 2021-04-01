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


import uz.micro.star.humo_atto_visa_union_pay_nfc_info_reader.R;

public final class SPEC {
	public enum PAGE {
		DEFAULT, INFO, ABOUT,
	}

	public enum EVENT {
		IDLE, ERROR, READING, FINISHED,
	}

	public enum PROP {
		ID(R.string.spec_prop_id),
		SERIAL(R.string.spec_prop_serial),
		PARAM(R.string.spec_prop_param),
		VERSION(R.string.spec_prop_version),
		DATE(R.string.spec_prop_date),
		COUNT(R.string.spec_prop_count),
		CURRENCY(R.string.spec_prop_currency),
		TLIMIT(R.string.spec_prop_tlimit),
		DLIMIT(R.string.spec_prop_dlimit),
		ECASH(R.string.spec_prop_ecash),
		BALANCE(R.string.spec_prop_balance),
		OLIMIT(R.string.spec_prop_olimit),
		TRANSLOG(R.string.spec_prop_translog),
		ACCESS(R.string.spec_prop_access),
		EXCEPTION(R.string.spec_prop_exception);

		public String toString() {
			return NfcReaderApplication.getStringResource(resId);
		}

		private final int resId;

		PROP(int resId) {
			this.resId = resId;
		}
	}

	public enum APP {
		UNKNOWN(R.string.spec_app_unknown),
		UNKNOWNCITY(R.string.spec_zip_unknown),
		SHENZHENTONG(R.string.spec_app_shenzhentong),
		QUICKPASS(R.string.spec_app_quickpass),
		OCTOPUS(R.string.spec_app_octopus_hk),
		BEIJINGMUNICIPAL(R.string.spec_app_beijing),
		WUHANTONG(R.string.spec_app_wuhantong),
		CHANGANTONG(R.string.spec_app_changantong),
		SHANGHAIGJ(R.string.spec_app_shanghai),
		DEBIT(R.string.spec_app_debit),
		CREDIT(R.string.spec_app_credit),
		QCREDIT(R.string.spec_app_qcredit),
		TUNIONEC(R.string.spec_app_tunion_ec),
		TUNIONEP(R.string.spec_app_tunion_ep),
		CITYUNION(R.string.spec_app_cityunion);

		public String toString() {
			return NfcReaderApplication.getStringResource(resId);
		}

		private final int resId;

		APP(int resId) {
			this.resId = resId;
		}
	}

	public enum CUR {
		UNKNOWN(R.string.spec_cur_unknown),
		USD(R.string.spec_cur_usd),
		CNY(R.string.spec_cur_cny);


		public String toString() {
			return NfcReaderApplication.getStringResource(resId);
		}

		private final int resId;

		CUR(int resId) {
			this.resId = resId;
		}
	}
}
