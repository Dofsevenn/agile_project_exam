package no.repairable.backend;

import no.repairable.backend.po.IndexPO;
import no.repairable.backend.po.ui.RestorePO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.atomic.AtomicInteger;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("dev")
public abstract class SeleniumTestBase {

    private static final AtomicInteger counter = new AtomicInteger(0);
    private IndexPO indexPO;

    protected abstract WebDriver getDriver();

    //@Autowired
    //private QuizService quizService;

    protected abstract String getServerHost();

    protected abstract int getServerPort();

    private String getUniqueId() {
        return "seleniumUser_" + counter.getAndIncrement();
    }

    @BeforeEach
    public void initTest() {
        //Need too delete cookies (independent testing priciple)
        getDriver().manage().deleteAllCookies();
        indexPO = new IndexPO(getDriver(), getServerHost(), getServerPort());

        indexPO.toStartingPage();
        assertTrue(indexPO.isOnPage());
    }


    @Test
    public void testViewIndex() {
        assertTrue(indexPO.isOnPage());
    }

    @Test
    public void testStartRestore() {
        assertTrue(indexPO.isOnPage());

        RestorePO po = indexPO.clickStart();

        assertNotNull(po);
    }


    @Test
    public void testViewProducts() {
        assertTrue(indexPO.isOnPage());

        RestorePO po = indexPO.clickStart();

        assertNotNull(po);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        assertTrue(po.productsVisible());
    }


    @Test
    public void testSelectProduct() {
        assertTrue(indexPO.isOnPage());

        RestorePO po = indexPO.clickStart();

        assertNotNull(po);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        assertTrue(po.productsVisible());

        po.clickFirstProduct();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        po.clickFirstSizeOption();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        po.clickAddProduct();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }


        assertTrue(po.isStep2());


    }


}
