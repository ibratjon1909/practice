package uz.personal.practice.api_integration;

import lombok.Getter;

@Getter
public class ApiConstant {

    //SMS API
    //172.18.10.37 uchun
    public static final String SMS_API_URL = "http://172.18.9.170/api/sms/send/";
    public static final String SMS_API_LOGIN = "ikkinchitalim";
    public static final String SMS_API_PASSWORD = "pmQgROZaRRaNHqdY";

    //Free SMS API
    public static final String SMS_FREE_URL = "http://94.158.52.192/api/edu_uz/sendsms.php";
    public static final String SMS_FREE_LOGIN = "minvuz";
    public static final String SMS_FREE_PASSWORD = "z7BH^U94#&de";

    //HEMIS ISHCHILAR API
    public static final String HEMIS_TOKEN_URL = "https://ministry.hemis.uz/app/rest/v2/oauth/token";
    public static final String DTM_TOKEN_URL = "https://iskm.egov.uz:9444/oauth2/token";
    public static final String DTM_MANDAT_URL = "https://apimgw.egov.uz:8243/dtm/service/mandat/v1";

    //ONE ID API
    public static final String ONE_ID_LOGIN = "khm_qabul";
    public static final String ONE_ID_PASSWORD = "pmQgROZaRRaNHqdY";

    //IIB API
    //172.18.10.37 uchun
    public static final String IIB_API_LOGIN = "ikkinchitalim";
    public static final String DTM_API_LOGIN = "minvuz_user1";
    public static final String IIB_API_PASSWORD = "pmQgROZaRRaNHqdY";
    public static final String DTM_API_PASSWORD = "m1nvuz!@#";

    //HEMIS INTEGRATION API
    public static final String HEMIS_INTEGRATION_API_URL = "https://172.18.8.11:8888/api/user/auth";
    public static final String HEMIS_INTEGRATION_API_USERNAME = "31407996240030";
    public static final String HEMIS_INTEGRATION_API_PASSWORD = "31407996240030";

    //billing.edu.uz
    public static final String BILLING_EDU_UZ_LOGIN = "centralbank";
    public static final String BILLING_EDU_UZ_PASSWORD = "YmFua2N0cmw6I0RUZSQ1XipfXz0qdGlvcl8rNGZra2Vtd28+NDM1ay80a3A1";

    //pro-emis.edu.uz
    public static final String PROF_EMIS_EDU_UZ_LOGIN = "get_contract_data";
    public static final String PROF_EMIS_EDU_UZ_PASSWORD = "Uvx20(:\\K<!lYu0R4|te";

    public static final String ACCOUNT_INVOICE = "<div style=\"font-family: 'Times New Roman',sans-serif;font-size: 14px; width: 190mm; line-height: normal;\">\n" +
            "  <div>\n" +
            "    <div style=\"display: flex; width: 100%;padding-right: 5mm\">\n" +
            "<!--      <div style=\"width: 60mm\"></div>-->\n" +
            "      <div style=\"text-align: center; flex-grow: 1; padding-left: 25mm\">\n" +
            "        <div>11.09.2023y. dagi № {contractNumber} - sonli</div>\n" +
            "        <div>shartnomaga {contractDate} dagi №\t- sonli</div>\n" +
            "        <div>HISOBVARAQ-FAKTURA</div>\n" +
            "      </div>\n" +
            "      <div>{qrCode}</div>\n" +
            "    </div>\n" +
            "    <div style=\"height: 20mm\"></div>\n" +
            "\n" +
            "    <div style=\"display: flex;justify-content: space-between;\">\n" +
            "      <div style=\"width: 110mm\">\n" +
            "        <div>TA’LIM MUASSASASI</div>\n" +
            "        <div>{univerName}</div>\n" +
            "        <div>H/r: {bill}</div>\n" +
            "        <div>STIR (INN) {tin}</div>\n" +
            "        <div>{bankInfo}</div>\n" +
            "        <div>Bank kodi (MFO) {mfo}</div>\n" +
            "        <div style=\"line-height: 10mm\">{univerName}</div>\n" +
            "        <div>{address}</div>\n" +
            "      </div>\n" +
            "      <div style=\"margin-right: 5mm\">\n" +
            "        <div style=\"width: 75mm\">\n" +
            "          <div>BUYURTMACHI:</div>\n" +
            "          <div style=\"border-bottom: 1px solid black; height: 4mm\"></div>\n" +
            "          <div style=\"border-bottom: 1px solid black; height: 4mm\"></div>\n" +
            "          <div style=\"border-bottom: 1px solid black; height: 4mm\"></div>\n" +
            "          <div style=\"border-bottom: 1px solid black; height: 4mm\"></div>\n" +
            "          <div style=\"border-bottom: 1px solid black; height: 4mm\"></div>\n" +
            "          <div style=\"border-bottom: 1px solid black; height: 4mm\"></div>\n" +
            "          <div style=\"border-bottom: 1px solid black; height: 4mm\"></div>\n" +
            "          <div style=\"border-bottom: 1px solid black; height: 4mm\"></div>\n" +
            "        </div>\n" +
            "      </div>\n" +
            "    </div>\n" +
            "    <div style=\"height: 15mm\"></div>\n" +
            "\n" +
            "    <table  style=\"width: 100%; border-collapse: collapse; text-align: center; border: 1px solid black\">\n" +
            "      <tr style=\"border: 1px solid black\">\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" rowspan=\"3\" colspan=\"4\"> Tovarning nomi (ish, xizmat)</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" rowspan=\"4\">O‘lchov birligi</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" rowspan=\"4\">Miqdori</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" colspan=\"2\" rowspan=\"4\">Narxi</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" colspan=\"2\" rowspan=\"4\">Yetkazib berish bahosi</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" colspan=\"2\" rowspan=\"3\">Aksiz solig‘i</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" colspan=\"2\" rowspan=\"3\">QQS</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" colspan=\"2\" rowspan=\"4\">AS va QQS bilan hisoblanganda yetkazib berish bahosi</td>\n" +
            "      </tr>\n" +
            "      <tr>\n" +
            "      </tr>\n" +
            "      <tr>\n" +
            "      </tr>\n" +
            "      <tr>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" colspan=\"4\">Bakalavr</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">Stavka</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">Summasi</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">Stavka</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">Summasi</td>\n" +
            "      </tr>\n" +
            "      <tr>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" colspan=\"4\">Mutaxassis tayyorlab berish</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">nafar</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">1</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" colspan=\"2\">{sum}</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" colspan=\"2\">{sum}</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">0</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">0</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">0</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">0</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" colspan=\"2\">{sum}</td>\n" +
            "      </tr>\n" +
            "      <tr>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" colspan=\"4\">Jami:</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">so‘m</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">1</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" colspan=\"2\">{sum}</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" colspan=\"2\">{sum}</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">x</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">x</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">x</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\">x</td>\n" +
            "        <td style=\"border: 1px solid black; padding: 0 2px\" colspan=\"2\">{sum}</td>\n" +
            "      </tr>\n" +
            "    </table>\n" +
            "\n" +
            "    <div style=\"height: 8mm\"></div>\n" +
            "    <div style=\" border-bottom: 1px solid black\">So‘z bilan: {sumText} so‘m</div>\n" +
            "    <div style=\"height: 30mm\"></div>\n" +
            "    <div style=\"display: flex; justify-content: space-between; width: 100%;\">\n" +
            "      <div style=\"width: 110mm\">\n" +
            "        <div style=\"display: flex; margin-bottom: 5mm\">Rektor: <div style=\"border-bottom: 1px solid black; min-width: 50mm; text-align: center\">{rector}</div></div>\n" +
            "        <div style=\"display: flex; margin-bottom: 5mm\">Bosh hisobchi: <div style=\"border-bottom: 1px solid black; min-width: 50mm; text-align: center\">{chiefAccountant}</div></div>\n" +
            "        <div style=\"display: flex\">Ijrochi: <div style=\"border-bottom: 1px solid black;width: 50mm; text-align: center\"></div></div>\n" +
            "        <div style=\"margin-left: 20mm\">Ijrochi masul imzosi</div>\n" +
            "      </div>\n" +
            "      <div>\n" +
            "        <div style=\"display: flex;\">\n" +
            "          20<div style=\"border-bottom: 1px solid black;min-width: 3mm ;\"> <span style=\"opacity: 0\">t</span></div>\n" +
            "          <div style=\"margin-left: 1mm\">y</div>\n" +
            "          <div style=\"margin-left: 2mm; display: flex\"><<  <div style=\"border-bottom: 1px solid black; min-width: 5mm\"><span style=\"opacity: 0\">t</span></div>  >></div>\n" +
            "          <div style=\"border-bottom: 1px solid black; min-width: 25mm; text-align: center\"><span style=\"opacity: 0\">t</span></div>dagi\n" +
            "        </div>\n" +
            "        <div>ishonchnomaga ko‘ra</div>\n" +
            "\n" +
            "        <div>Qabul qilubchi:</div>\n" +
            "        <div style=\"border-bottom: 1px solid black; min-width: 40mm; text-align: center; margin-bottom: 4mm\"><span style=\"opacity: 0\">t</span></div>\n" +
            "        <div style=\"display: flex; margin-bottom: 5mm\">F.I.O. <div style=\"border-bottom: 1px solid black; min-width: 50mm; text-align: center\"><span style=\"opacity: 0\">t</span></div></div>\n" +
            "\n" +
            "        <div style=\"display: flex;\">\n" +
            "          <div style=\"margin-left: 2mm; display: flex\"><<  <div style=\"border-bottom: 1px solid black; min-width: 5mm\"><span style=\"opacity: 0\">t</span></div>  >></div>\n" +
            "          <div style=\"border-bottom: 1px solid black; min-width: 25mm; text-align: center\"><span style=\"opacity: 0\">t</span></div>\n" +
            "          20<div style=\"border-bottom: 1px solid black;min-width: 3mm\"><span style=\"opacity: 0\">t</span></div>\n" +
            "        </div>\n" +
            "\n" +
            "      </div>\n" +
            "    </div>\n" +
            "\n" +
            "\n" +
            "  </div>\n" +
            "</div>\n";
}
