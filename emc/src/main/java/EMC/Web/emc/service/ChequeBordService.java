package EMC.Web.emc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import EMC.Web.emc.entities.Bordereau;
import EMC.Web.emc.entities.Cheque;
import EMC.Web.emc.entities.User;
import EMC.Web.emc.exception.UserNotFoundException;
import EMC.Web.emc.repo.BordereauRepository;
import EMC.Web.emc.repo.ChequeRepository;


@Service
@Transactional
public class ChequeBordService {
	 private final ChequeRepository repoC;
	 private final BordereauRepository repoB;
	    @Autowired
	    public ChequeBordService(ChequeRepository Repo,BordereauRepository RepoB) {
	        this.repoC = Repo;
	        this.repoB=RepoB;
	    }
	    public Integer LonguerCheque(Long numcheque) {
	    	String cheque = numcheque.toString();
	    	int len =cheque.length();
	    	if(len==7) {
	    		return 1;
	    	}
	    	else {
	    		return 2;
	    	}
	    }
	    
	    public Cheque créerCheque(Long numCheque,Float montant,String devise,Bordereau bor ) {
	    	Cheque ch=new Cheque(numCheque,montant,devise,null,null,bor,null,null,null);
	    	return ch;
	    }
	    public Bordereau créerBordereau(Long numBordereau,Date datBbordereau,Set<Cheque> chequeList ) {
	    	Bordereau bordereau=new Bordereau(numBordereau,datBbordereau,chequeList);
	    	return bordereau;
	    }
	    
	    public Bordereau RechercherBordereau(Long numBordereau ) {
	  	    	return repoB.findById(numBordereau)
	  	    			.orElseThrow(() -> new UserNotFoundException("bordereau introuvable"));
	    	
	    }
	    
	    public Cheque RechercherCheque(Long numCheque ) {
  	    	return repoC.findById(numCheque)
  	    			.orElseThrow(() -> new UserNotFoundException("cheque introuvable"));
    	
    }
	    
	    public Boolean ChequeExistant(Long numCheque) {
	    	if(repoC.findById(numCheque).isPresent()) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	    }
	    
	    public Set<Bordereau> afficherBordereau(){
		    Set<Bordereau> liste=repoB.listeBordereau(new Date());
			if(liste.isEmpty()) {
				return null;
			}
			else {
				return liste ;
			}

	    }
	    
	   
	    
	    
	    
	    
}