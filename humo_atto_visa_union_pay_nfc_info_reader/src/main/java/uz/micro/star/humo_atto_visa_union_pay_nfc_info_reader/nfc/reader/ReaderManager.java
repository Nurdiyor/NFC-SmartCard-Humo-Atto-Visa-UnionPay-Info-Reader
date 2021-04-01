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

package uz.micro.star.humo_atto_visa_union_pay_nfc_info_reader.nfc.reader;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcF;
import android.os.AsyncTask;

import uz.micro.star.humo_atto_visa_union_pay_nfc_info_reader.nfc.Util;
import uz.micro.star.humo_atto_visa_union_pay_nfc_info_reader.nfc.bean.Card;
import uz.micro.star.humo_atto_visa_union_pay_nfc_info_reader.nfc.reader.pboc.StandardPboc;
import uz.micro.star.humo_atto_visa_union_pay_nfc_info_reader.nfc.SPEC;

public final class ReaderManager extends AsyncTask<Tag, SPEC.EVENT, Card> {

	public static void readCard(Tag tag, ReaderListener listener) {
		new ReaderManager(listener).execute(tag);
	}

	private ReaderListener realListener;

	private ReaderManager(ReaderListener listener) {
		realListener = listener;
	}

	@Override
	protected Card doInBackground(Tag... detectedTag) {
		return readCard(detectedTag[0]);
	}

	@Override
	protected void onProgressUpdate(SPEC.EVENT... events) {
		if (realListener != null)
			realListener.onReadEvent(events[0]);
	}

	@Override
	protected void onPostExecute(Card card) {
		if (realListener != null)
			realListener.onReadEvent(SPEC.EVENT.FINISHED, card);
	}

	private Card readCard(Tag tag) {

		final Card card = new Card();

		try {

			publishProgress(SPEC.EVENT.READING);

			card.setProperty(SPEC.PROP.ID, Util.toHexString(tag.getId()));

			final IsoDep isodep = IsoDep.get(tag);
			if (isodep != null)
				StandardPboc.readCard(isodep, card);

			final NfcF nfcf = NfcF.get(tag);
			if (nfcf != null)
//				FelicaReader.readCard(nfcf, card);

			publishProgress(SPEC.EVENT.IDLE);

		} catch (Exception e) {
			card.setProperty(SPEC.PROP.EXCEPTION, e);
			publishProgress(SPEC.EVENT.ERROR);
		}

		return card;
	}
}
