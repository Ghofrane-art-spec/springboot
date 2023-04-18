package EMC.Web.emc.controlleur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import EMC.Web.emc.entities.Bordereau;
import EMC.Web.emc.entities.Cheque;
import EMC.Web.emc.repo.BordereauRepository;
import EMC.Web.emc.repo.ChequeRepository;
import EMC.Web.emc.service.ChequeBordService;

@RestController
public class ChequeBordereauControlleur {
	@Autowired
	ChequeBordService chequeBorSer;
	@Autowired
	ChequeRepository chequeRepo;
	@Autowired
	BordereauRepository borRepo;
	
	

	@GetMapping("/saisieCh/{numCheque}/{montant}/{devise}")
	public ResponseEntity<Cheque> saisieCh(@PathVariable("numCheque") Long numCheque, 
	                                        @PathVariable("montant") Float montant, 
	                                        @PathVariable("devise") String devise) {
	    try {
	        if (chequeBorSer.LonguerCheque(numCheque) == 1) {
	            Cheque ch = chequeBorSer.créerCheque(numCheque, montant, devise, null);
	            return new ResponseEntity<Cheque>(ch, HttpStatus.OK);
	        } else {
	            System.out.println("Numero cheque incorrect");
	            return null;
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        return null;
	    }
	}

	@GetMapping("/saisieB/{numbordereau}")
	public ResponseEntity<Bordereau> saisieB(@PathVariable("numbordereau") Long numBordereau) {
	    try {
	        Set<Cheque> listCheque = new HashSet<>();
	        Bordereau bordereau = chequeBorSer.créerBordereau(numBordereau, new Date(), listCheque);
	        return new ResponseEntity<Bordereau>(bordereau, HttpStatus.OK);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        return null;
	    }
	}

	@PostMapping("/saisieTest")
	public ResponseEntity<String> saisieTest(@RequestBody Map<String, Object> requestMap) {
	    Cheque cheque = new ObjectMapper().convertValue(requestMap.get("cheque"), Cheque.class);
	    Bordereau bordereau = new ObjectMapper().convertValue(requestMap.get("bordereau"), Bordereau.class);
	    try {
	        if (bordereau.getListeCh() == null) {
	            bordereau.setListeCh(new HashSet<Cheque>());
	        }
	        bordereau.getListeCh().add(cheque);
	        chequeRepo.save(cheque);
	        borRepo.save(bordereau);
	        cheque.setBordereau(bordereau);
	        chequeRepo.save(cheque);
	        return new ResponseEntity<String>("Cheque saved successfully", HttpStatus.CREATED);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        return new ResponseEntity<String>("Error saving the cheque", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

			
	
	@GetMapping("/ChequeExist/{numCheque}")
	public ResponseEntity<Integer> NumCheque(@PathVariable("numCheque")Long numCheque) {
		Integer t=chequeBorSer.LonguerCheque(numCheque);
		return new ResponseEntity<>(t, HttpStatus.OK);
	}
	
	
	
	//Search
	
	@GetMapping("/rechercherCh/{numCheque}")
	   public ResponseEntity<Cheque> rechercherCheque(@PathVariable("numCheque")Long numCheque) {
		Cheque cheque=chequeBorSer.RechercherCheque(numCheque);
		return new ResponseEntity<>(cheque, HttpStatus.OK);
	}
	@GetMapping("/chequeExistant/{numCheque}")
	public ResponseEntity<Boolean> chequeExistant(@PathVariable("numCheque")Long numCheque) {
		Boolean test=chequeBorSer.ChequeExistant(numCheque);
		return new ResponseEntity<>(test, HttpStatus.OK);
	}
	//finJournée
	
	@GetMapping("/finJournée")
	   public ResponseEntity<Set<Bordereau>> finJournée() {
		Set<Bordereau> liste =chequeBorSer.afficherBordereau();
		return new ResponseEntity<>(liste, HttpStatus.OK);
	}
	

	
	
	
	
	
	
	
	//to test list
	@GetMapping("/nombre1")
	public ResponseEntity<Integer> nombre(@RequestParam("numbordereau")Long numBordereau) {
		Bordereau bordereau=chequeBorSer.RechercherBordereau(numBordereau);
		Integer a=bordereau.getListeCh().size();
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

}
