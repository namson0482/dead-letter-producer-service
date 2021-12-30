package son.vu.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import son.vu.constant.Constants;
import son.vu.model.CardServiceRequestBodyDTO;
import son.vu.model.CardServiceRequestDTO;

public class CommonUtil {


	/**
	 * check value to be either null or empty
	 * @param value need to check
	 * @return 
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNullOrEmpty(Object value) {
		if (value == null) return true;
		if (value instanceof String) return "".equals(value.toString().trim());
		else if (value instanceof Collection) {
			Collection c = (Collection) value;
			if (c.isEmpty()) return true;
			for (Object obj : c) 
				if (!isNullOrEmpty(obj)) return false;
			return true;
		} else if (value instanceof Map) {
			Map m = (Map) value;
			if (m.isEmpty()) return true;
			Iterator iterator = m.keySet().iterator();
			while (iterator.hasNext()) 
				if (!isNullOrEmpty(iterator.next())) return false;
			return true;
		} else if (value.getClass().isArray()) return (((Object[]) value).length <= 0);
		else if (value instanceof Class && ((Class) value).isPrimitive()) return ((long) value) < 0;
		else return false;
	}

	
	/**
	 * convert JSon string to CardServiceRequestDTO object 
	 * @param objectMapper 
	 * @param json payload received from RabbitMQ
	 * @return CardServiceRequestDTO object
	 * @throws AcbException JSon exception
	 */
	public final static CardServiceRequestDTO parseCardServiceJSonString(ObjectMapper objectMapper, String json) throws Exception {

		String exceptionMsg = "";
		try {
			JsonNode parentNode = objectMapper.readTree(json);
			String requestTypCd = parentNode.get(Constants.CARD_SERVICE_PRODUCER_REQUESTTYPECD).asText();
			if (requestTypCd.equalsIgnoreCase("CREATE")) {
				CardServiceRequestDTO cardServiceRequestDTO = new CardServiceRequestDTO();
				cardServiceRequestDTO.setRequestTypCd("CREATE");

				CardServiceRequestBodyDTO cardServiceRequestBodyDTO = new CardServiceRequestBodyDTO();
				cardServiceRequestDTO.setCardServiceRequestBodyDTO(cardServiceRequestBodyDTO);
				
				long reqNbr = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_REQNBR)
						.asLong();
				cardServiceRequestBodyDTO.setReqNbr(reqNbr);
				
				//check again
				long ctNbr = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_CTNBR)
						.asLong();
				cardServiceRequestBodyDTO.setRbsNumber(ctNbr + "");
				cardServiceRequestBodyDTO.setAcctNbr(ctNbr);
				
				String cardCd = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_CARDCD)
						.asText();
				cardServiceRequestBodyDTO.setCardCd(cardCd);
				
				String cardDesc = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_CARDDESC)
						.asText();
				cardServiceRequestBodyDTO.setCardDesc(cardDesc);
				
				long persNbr = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_PERSNBR)
						.asLong();
				cardServiceRequestBodyDTO.setPersNbr(persNbr);
				
				String nhanXung = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_NHANXUNG)
						.asText();
				cardServiceRequestBodyDTO.setNhanXung(nhanXung);
				
				String embossingName = parentNode.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/"
						+ Constants.CARD_SERVICE_PRODUCER_EMBOSSINGNAME).asText();
				cardServiceRequestBodyDTO.setEmbossingName(embossingName);
				
				String ngaySinh = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_NGAYSINH)
						.asText();
				cardServiceRequestBodyDTO.setNgaySinh(ngaySinh);
				
				String gioiTinh = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_GIOITINH)
						.asText();
				cardServiceRequestBodyDTO.setGioiTinh(gioiTinh);
				
				//not yet have TTHONNHAN
				
				String nhanVien = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_NHANVIEN)
						.asText();
				cardServiceRequestBodyDTO.setNhanVien(nhanVien);
				
				String noiGuiTb = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_NOIGUITB)
						.asText();
				cardServiceRequestBodyDTO.setNoiGuiTb(noiGuiTb);
				
				long cnNhanThe = parentNode.at(
						"/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_CNNHANTHE)
						.asLong();
				cardServiceRequestBodyDTO.setCnNhanThe(cnNhanThe);
				
				String soNha = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_SONHA)
						.asText();
				cardServiceRequestBodyDTO.setSoNha(soNha);
				
				String duong = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_DUONG)
						.asText();
				cardServiceRequestBodyDTO.setDuong(duong);
				
				String tp = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_TP)
						.asText();
				cardServiceRequestBodyDTO.setTp(tp);

				String tell = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_TELL)
						.asText();
				cardServiceRequestBodyDTO.setTell(tell);
				
				String email = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_EMAIL)
						.asText();
				cardServiceRequestBodyDTO.setEmail(email);
				
				String mobile = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_MOBILE)
						.asText();
				cardServiceRequestBodyDTO.setMobile(mobile);
				
				String feeCd = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_FEECD)
						.asText();
				cardServiceRequestBodyDTO.setFeeCd(feeCd);
				
				String ptncd = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_PTNCD)
						.asText();
				cardServiceRequestBodyDTO.setPtncd(ptncd);

				String pgncd = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_PGNCD)
						.asText();
				cardServiceRequestBodyDTO.setPgncd(pgncd);

				String pemvcd = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_PEMVCD)
						.asText();
				cardServiceRequestBodyDTO.setPemvcd(pemvcd);
				
				String effDate = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_EFFDATE)
						.asText();
				cardServiceRequestBodyDTO.setEffDate(effDate);

				long orgBranchNbr = parentNode.at(
						"/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_ORGBRANCHNBR)
						.asLong();
				cardServiceRequestBodyDTO.setOrgBranchNbr(orgBranchNbr);

				String firstName = parentNode.at(
						"/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_FIRSTNAME)
						.asText();
				cardServiceRequestBodyDTO.setFirstName(firstName);

				String lastName = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_LASTNAME)
						.asText();
				cardServiceRequestBodyDTO.setLastName(lastName);
				
				String cmnd = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_CMND)
						.asText();
				cardServiceRequestBodyDTO.setCmnd(cmnd);

				String quocTich = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_QUOCTICH)
						.asText();
				cardServiceRequestBodyDTO.setQuocTich(quocTich);

				String userName = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_USERNAME)
						.asText();
				cardServiceRequestBodyDTO.setUserName(userName);
				
				
				long holdAcctNbr = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_HOLDACCTNBR)
						.asLong();
				cardServiceRequestBodyDTO.setHoldAcctNbr(holdAcctNbr);
				
				String accHoldCd = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_ACCHOLDCD)
						.asText();
				cardServiceRequestBodyDTO.setAccHoldCd(accHoldCd);
				
				long holdSeNbr = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_HOLDSEQNBR)
						.asLong();
				cardServiceRequestBodyDTO.setHoldSeNbr(holdSeNbr);
				
				long holdAMT = parentNode
						.at("/" + Constants.CARD_SERVICE_PRODUCER_DATA + "/" + Constants.CARD_SERVICE_PRODUCER_HOLDAMT)
						.asLong();
				cardServiceRequestBodyDTO.setHoldAMT(holdAMT);
				
				return cardServiceRequestDTO;

			}
		} catch (JsonMappingException e) {
			exceptionMsg = e.getMessage();
		} catch (JsonProcessingException e) {
			exceptionMsg = e.getMessage();
		}
		throw new Exception(exceptionMsg);
	}


}
