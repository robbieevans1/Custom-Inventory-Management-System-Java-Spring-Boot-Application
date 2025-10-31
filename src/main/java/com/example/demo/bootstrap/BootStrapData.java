package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final InhousePartRepository inhousePartRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository,InhousePartRepository inhousePartRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository=inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (partRepository.count()==0 && productRepository.count() ==0 && inhousePartRepository.count()==0){
            InhousePart muffler = new InhousePart();
            muffler.setName("Paradox Muffler");
            muffler.setInv(21);
            muffler.setPrice(5555);
            muffler.setId(21);
            inhousePartRepository.save(muffler);

            InhousePart spool = new InhousePart();
            spool.setName("Reality Rewinder Spool");
            spool.setInv(100);
            spool.setPrice(2000);
            spool.setId(764);
            inhousePartRepository.save(spool);

            InhousePart carburetor = new InhousePart();
            carburetor.setName("Causality Carburetor");
            carburetor.setInv(117);
            carburetor.setPrice(942);
            carburetor.setId(291);
            inhousePartRepository.save(carburetor);

            OutsourcedPart core = new OutsourcedPart();
            core.setName("Chrono Core Stabilizer");
            core.setInv(15);
            core.setPrice(15555);
            core.setId(218);
            core.setCompanyName("Future Flight");
            outsourcedPartRepository.save(core);

            OutsourcedPart turbocCore = new OutsourcedPart();
            turbocCore.setName("Mighty Turbo Core Stabilizer");
            turbocCore.setInv(10);
            turbocCore.setPrice(14000);
            turbocCore.setId(640);
            turbocCore.setCompanyName("Excellsior");
            outsourcedPartRepository.save(turbocCore);


            Product pastFinder = new Product();
            pastFinder.setName("PastFinder Pro");
            pastFinder.setInv(254);
            pastFinder.setPrice(1000000);
            pastFinder.setId(856);
            productRepository.save(pastFinder);

            Product falcon = new Product();
            falcon.setName("Tempus Falcon");
            falcon.setInv(7);
            falcon.setPrice(1500000);
            falcon.setId(789);
            productRepository.save(falcon);

            Product glass = new Product();
            glass.setName("Hourglass NX");
            glass.setInv(5);
            glass.setPrice(1500000);
            glass.setId(154);
            productRepository.save(glass);

            Product engine = new Product();
            engine.setName("Eclipse Engine Zero");
            engine.setInv(4);
            engine.setPrice(1500000);
            engine.setId(155);
            productRepository.save(engine);

            Product beetle = new Product();
            beetle.setName("Quantum Beetle");
            beetle.setInv(7);
            beetle.setPrice(1500000);
            beetle.setId(156);
            productRepository.save(beetle);
        }




        //if (partRepository.count() ==0)
            //InhousePart muffler = new InhousePart();


       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
