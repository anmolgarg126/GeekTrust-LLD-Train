package org.lld.problems.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;


class TrainServiceTest {

    @ParameterizedTest
    @CsvSource({
            "TRAIN_A ENGINE NDL NDL KRN GHY SLM NJP NGP BLR,ARRIVAL TRAIN_A ENGINE NDL NDL GHY NJP NGP",
            "TRAIN_B ENGINE NJP GHY AGA PNE MAO BPL PTA,ARRIVAL TRAIN_B ENGINE NJP GHY AGA BPL PTA",
            "TRAIN_A ENGINE SLM BLR KRN HYB SLM NGP ITJ,ARRIVAL TRAIN_A ENGINE HYB NGP ITJ",
            "TRAIN_B ENGINE SRR MAO NJP PNE PTA,ARRIVAL TRAIN_B ENGINE NJP PTA",
            "TRAIN_A ENGINE NGP KRN NGP NDL HYB BPL,ARRIVAL TRAIN_A ENGINE NGP NGP NDL HYB BPL",
            "TRAIN_B ENGINE GHY PTA NJP PNE MAQ BPL,ARRIVAL TRAIN_B ENGINE GHY PTA NJP BPL",
            "TRAIN_A ENGINE BLR AGA BLR HYB ITJ BPL,ARRIVAL TRAIN_A ENGINE AGA HYB ITJ BPL",
            "TRAIN_B ENGINE PTA HYB BPL ITJ SRR NJP,ARRIVAL TRAIN_B ENGINE PTA HYB BPL ITJ NJP"
    })
    void getArrivalOrder_test1(String input, String expectedOutput) {
        List<String> stops = Arrays.asList(input.split("\\s+"));
        String res = TrainService.getArrivalOrder(stops);
        Assertions.assertEquals(expectedOutput, res);
    }

    @ParameterizedTest
    @CsvSource({
            "TRAIN_A ENGINE NDL NDL KRN GHY SLM NJP NGP BLR,TRAIN_B ENGINE NJP GHY AGA PNE MAO BPL PTA,DEPARTURE TRAIN_AB ENGINE ENGINE GHY GHY NJP NJP PTA NDL NDL AGA BPL NGP",
            "TRAIN_A ENGINE SLM BLR KRN HYB SLM NGP ITJ,TRAIN_B ENGINE SRR MAO NJP PNE PTA,DEPARTURE TRAIN_AB ENGINE ENGINE NJP PTA ITJ NGP",
            "TRAIN_A ENGINE BLR AGA BLR HYB ITJ BPL,TRAIN_B ENGINE PTA HYB BPL ITJ SRR NJP,DEPARTURE TRAIN_AB ENGINE ENGINE NJP PTA AGA BPL BPL ITJ ITJ",
            "TRAIN_A ENGINE NGP KRN NGP NDL HYB BPL,TRAIN_B ENGINE GHY PTA NJP PNE MAQ BPL,DEPARTURE TRAIN_AB ENGINE ENGINE GHY NJP PTA NDL BPL BPL NGP NGP"
    })
    void getDepartureOrder(String trainA, String trainB, String expectedOutput) {
        List<String> trainAStops = Arrays.asList(trainA.split("\\s+"));
        List<String> trainBStops = Arrays.asList(trainB.split("\\s+"));
        String res = TrainService.getDepartureOrder(trainAStops, trainBStops);
        Assertions.assertEquals(expectedOutput, res);
    }
}