module br.ufrpe.byte_monstro.byte_monstro_fx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens br.ufrpe.byte_monstro.byte_monstro_fx to javafx.fxml;
    exports br.ufrpe.byte_monstro.byte_monstro_fx;
}