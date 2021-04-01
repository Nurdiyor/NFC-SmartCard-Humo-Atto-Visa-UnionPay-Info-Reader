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

package uz.micro.star.humo_atto_visa_union_pay_nfc_info_reader.nfc.bean;

import java.util.Collection;
import java.util.LinkedHashMap;

import uz.micro.star.humo_atto_visa_union_pay_nfc_info_reader.nfc.SPEC;


public class Card extends Application {
    public static final Card EMPTY = new Card();
    private final LinkedHashMap<Object, Application> applications;
    private String cardNumber;
    private String cardExpiredDate;

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardExpiredDate() {
        return cardExpiredDate;
    }

    public Card() {
        applications = new LinkedHashMap<Object, Application>(2);
    }

    public Exception getReadingException() {
        return (Exception) getProperty(SPEC.PROP.EXCEPTION);
    }

    public boolean hasReadingException() {
        return hasProperty(SPEC.PROP.EXCEPTION);
    }

    public final boolean isUnknownCard() {
        return applicationCount() == 0;
    }

    public final int applicationCount() {
        return applications.size();
    }

    public final Collection<Application> getApplications() {
        return applications.values();
    }

    public final void addApplication(Application app) {
        if (app != null) {
            Object id = app.getProperty(SPEC.PROP.ID);
            if (id != null && !applications.containsKey(id))
                applications.put(id, app);
        }
    }

    //    public String toHtml() {
//        return HtmlFormatter.formatCardInfo(this);
//    }
    public String getSerial() {
        final StringBuilder ret = new StringBuilder();
        Collection<Application> apps = this.getApplications();
        for (Application app : apps) {
            ret.append("\n");
            ret.append("---------------------------------------------");
            ret.append("\n");
            ret.append("Card number: ");
            ret.append(app.getStringProperty(SPEC.PROP.SERIAL));
            ret.append("\n");
            ret.append("Card date: ");
            ret.append(app.getStringProperty(SPEC.PROP.DATE));
            ret.append("\n");
            ret.append("---------------------------------------------");
            ret.append("\n");
        }
        return ret.toString();
    }

    public Card getSerialAndDate() {
        Card card = new Card();
        Collection<Application> apps = this.getApplications();
        for (Application app : apps) {
            card.cardNumber = app.getStringProperty(SPEC.PROP.SERIAL);
            card.cardExpiredDate = app.getStringProperty(SPEC.PROP.DATE);
        }
        return card;
    }
}
