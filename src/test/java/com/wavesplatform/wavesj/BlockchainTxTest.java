package com.wavesplatform.wavesj;

import org.junit.Test;

public class BlockchainTxTest {
    private static final long AMOUNT =     100_000;
    private static final long FEE    = 100_000_000;

    @Test
    public void smokeTest() {
        PrivateKeyAccount acc = new PrivateKeyAccount("CMLwxbMZJMztyTJ6Zkos66cgU7DybfFJfyJtTVpme54t", 'T');
        String recipient = "3N9gDFq8tKFhBDBTQxR3zqvtpXjw5wW3syA";
        String assetId = "AssetAssetAssetAssetAssetAssetAs";
        String txId = "TransactionTransactionTransactio";

        dump("alias",
                BlockchainTransaction.makeAliasTx(acc, "daphnie", FEE));
        dump("burn",
                BlockchainTransaction.makeBurnTx(acc, assetId, AMOUNT, FEE));
        dump("issue",
                BlockchainTransaction.makeIssueTx(acc, "Pure Gold", "Gold backed asset", AMOUNT, 8, true, FEE));
        dump("reissue",
                BlockchainTransaction.makeReissueTx(acc, assetId, AMOUNT, false, FEE));
        dump("lease",
                BlockchainTransaction.makeLeaseTx(acc, recipient, AMOUNT, FEE));
        dump("lease cancel",
                BlockchainTransaction.makeLeaseCancelTx(acc, txId, FEE));
        dump("xfer",
                BlockchainTransaction.makeTransferTx(acc, recipient, AMOUNT, null, FEE, null, "Shut up & take my money"));
    }

    private void dump(String header, BlockchainTransaction tx) {
        System.out.println("*** " + header + " ***");
        System.out.println("Tx data: " + tx.getJson());
        System.out.println("Encoded bytes: " + tx.getEncodedBytes());
        System.out.println();
    }
}
