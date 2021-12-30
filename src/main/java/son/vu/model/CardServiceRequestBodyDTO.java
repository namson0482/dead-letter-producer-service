package son.vu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardServiceRequestBodyDTO {
	
	private long reqNbr;
	
	private long acctNbr;
	
	private String cardCd;
	
	private String cardDesc;
	
	private long persNbr;
	
	private String nhanXung;
	
	private String embossingName;
	
	private String ngaySinh;
	
	private String gioiTinh;
	
	private String ttHonNhan;
	
	private String passportNbr;
	
	private long thuNhap;
	
	private String nhanVien;
	
	private String spouseName;
	
	private String motherName;
	
	private String noiGuiTb;
	
	private long cnNhanThe;
	
	private String soNha;
	
	private String duong;
	
	private String tp;
	
	private String tell;
	
	private String email;
	
	private String mobile;
	
	private String tenCty;
	
	private String chucVuCty;
	
	private String soNhaCty;
	
	private String duongCty;
	
	private String tpCty;
	
	private String tellCty;
	
	private String feeCd;
	
	private String ptncd;
	
	private String pgncd;
	
	private String pemvcd;
	
	private String mail;
	
	private String bill;
	
	private String net;
	
	private String effDate;
	
	private long cashBox;
	
	private long orgPersNbr;
	
	private long orgBranchNbr;
	
	private String refName;
	
	private String refTaxId;
	
	private String refDateBir;
	
	private String refSex;
	
	private String refRelationship;
	
	private String refDesCompany;
	
	private String refAddr1;
	
	private String refAddr2;
	
	private String refAddr3;
	
	private String refPhone;
	
	private String noiNhanThe;
				
	private String reAddrUseCd ;
	
	private long applicantNbr;
	
	private String cardNbr ;
	
	private long errorNbr;
	
	private String errorMsg ;
	
	private String oraErrorMsg ;
	
	private String cmnd;
	
	private String quocTich;
	
	private String userName;
	
	private String postDate;
	
	private String rbsNumber;
	
	private String firstName;
	
	private String lastName;
	
	private  String orderDprt;
	
	private String serviceCenterCd;
	
	private long holdAcctNbr;	
	
	private String accHoldCd ;
	
	private long holdSeNbr;
	
	private long holdAMT;
	//OrderDprt
	
}
