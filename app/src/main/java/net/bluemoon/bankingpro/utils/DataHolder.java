package net.bluemoon.bankingpro.utils;

import net.bluemoon.bankingpro.models.SingleBank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mvnpavan on 31/01/16.
 */
public class DataHolder {

    public final String[] bankUrls = new String[]{
                    "https://www.allbankonline.in/jsp/startnew.jsp",
                    "http://www.axisbank.com/",
                    "https://www.onlineandhrabank.net.in/",
                    "http://www.bbkonline.com/",
                    "https://www.bobibanking.com/",
                    "http://www.bankofindia.co.in/english/home.aspx",
                    "http://www.bankofmaharashtra.in/",
                    "https://www.canarabank.in/",
                    "https://www.centralbankofindia.co.in/site/indexcbi.aspx",
                    "http://www.cityunionbank.com/english/home.aspx",
                    "http://www.corpbank.com/",
                    "https://www.online.citibank.co.in/",
                    "https://www.csbnet.co.in/",
                    "http://www.denabank.com/index.jsp",
                    "http://www.deutschebank.co.in/banking.html",
                    "https://www.dcbbank.com/",
                    "http://www.dhanbank.com/",
                    "http://www.federalbank.co.in/",
                    "https://netbanking.hdfcbank.com/netbanking/",
                    "http://www.icicibank.com/",
                    "http://www.idbi.com/index.asp",
                    "http://www.indian-bank.com/",
                    "http://www.indusind.com/",
                    "https://www.iob.in/",
                    "https://onlineingvysya.kotak.com",
                    "http://www.idfcbank.com/",
                    "http://www.jkbank.net/",
                    "http://www.karnatakabank.com/ktk/Index.jsp",
                    "http://www.kvb.co.in/",
                    "http://www.kotak.com/",
                    "http://www.lvbank.com/",
                    "https://www.obcindia.co.in/obcnew/site/index.aspx",
                    "https://www.netpnb.com/index.html",
                    "https://www.psbindia.com/",
                    "http://www.rblbank.com/",
                    "http://www.svcbank.com/",
                    "https://www.southindianbank.com/",
                    "https://www.sbbjbank.com/indexE.htm",
                    "https://www.sbhyd.com/",
                    "https://www.onlinesbi.com/",
                    "https://www.onlinesbm.com/",
                    "https://www.sbp.co.in/",
                    "http://www.statebankoftravancore.com/portal/home",
                    "http://www.syndicatebank.in/english/home.aspx",
                    "http://www.tmb.in/",
                    "https://www.ucobank.com/",
                    "http://www.unionbankofindia.co.in/",
                    "http://www.unitedbankofindia.com/english/home.aspx",
                    "https://www.vijayabank.com/",
                    "https://www.yesbank.in/"

            };

    public final String[] bankNames = new String[]{

            "Allahabad Bank",
            "Axis Bank",
            "Andhra Bank",
            "Bank of Bahrain and Kuwait",
            "Bank of Baroda",
            "Bank of India",
            "Bank of Maharashtra",
            "Canara Bank",
            "Central Bank of India",
            "City Union Bank",
            "Corporation Bank",
            "Citi Bank",
            "Catholic Syrian Bank",
            "Dena Bank",
            "Deutsche Bank",
            "Development Credit Bank",
            "Dhanlaxmi Bank",
            "Federal Bank",
            "HDFC Bank",
            "ICICI Bank",
            "IDBI Bank",
            "Indian Bank",
            "IndusInd Bank",
            "Indian Overseas Bank",
            "ING Vysya Bank",
            "IDFC Bank",
            "Jammu and Kashmir Bank",
            "Karnataka Bank Ltd",
            "Karur Vysya Bank",
            "Kotak Bank",
            "Laxmi Vilas Bank",
            "Oriental Bank of Commerce",
            "Punjab National Bank",
            "Punjab & Sind Bank",
            "RBL Bank",
            "Shamrao Vitthal Co-operative Bank",
            "South Indian Bank",
            "State Bank of Bikaner & Jaipur",
            "State Bank of Hyderabad",
            "State Bank of India",
            "State Bank of Mysore",
            "State Bank of Patiala",
            "State Bank of Travancore",
            "Syndicate Bank",
            "Tamilnad Mercantile Bank Ltd.",
            "UCO Bank",
            "Union Bank of India",
            "United Bank of India",
            "Vijaya Bank",
            "Yes Bank Ltd"
    };

    public final String[] bankImages = new String[]{
            "bank_one",
            "bank_two",
            "bank_three",
            "bank_four",
            "bank_five",
            "bank_six",
            "bank_seven",
            "bank_eight",
            "bank_nine",
            "bank_ten",
            "bank_eleven",
            "bank_fourtysix",
            "bank_fourtyseven",
            "bank_fourtyeight",
            "bank_twelve",
            "bank_thirteen",
            "bank_fourteen",
            "bank_fifteen",
            "bank_fourtyfive",
            "bank_sixteen",
            "bank_seventeen",
            "bank_eighteen",
            "bank_nineteen",
            "bank_twenty",
            "bank_twentyone",
            "bank_fourtynine",
            "bank_twentytwo",
            "bank_twentythree",
            "bank_twentyfour",
            "bank_twentyfive",
            "bank_twentysix",
            "bank_twentyseven",
            "bank_twentyeight",
            "bank_twentynine",
            "bank_fifty",
            "bank_thirty",
            "bank_thirtyone",
            "bank_thirtytwo",
            "bank_thirtythree",
            "bank_thirtyfour",
            "bank_thirtyfive",
            "bank_thirtysix",
            "bank_thirtyseven",
            "bank_thirtyeight",
            "bank_thirtynine",
            "bank_fourty",
            "bank_fourtyone",
            "bank_fourtytwo",
            "bank_fourtythree",
            "bank_fourtyfour"

    };

    public List<SingleBank> getBankList(){

        List<SingleBank> banks = new ArrayList<>();

        for (int i = 0; i<bankUrls.length ; i++){
            SingleBank bank = new SingleBank();
            bank.setBank_Id(i);
            bank.setBank_url(bankUrls[i]);
            bank.setBank_name(bankNames[i]);
            bank.setBank_img(bankImages[i]);

            banks.add(bank);
        }

        return banks;
    }
}
