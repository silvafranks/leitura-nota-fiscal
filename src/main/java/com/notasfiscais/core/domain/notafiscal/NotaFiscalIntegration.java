package com.notasfiscais.core.domain.notafiscal;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@XmlRootElement(name = "nfeProc")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotaFiscalIntegration {
    private final static String FIELD_NAMESPACE = "";

    @XmlElement(name = "NFe", namespace = FIELD_NAMESPACE)
    private NFe NFe;

    @XmlElement(name = "protNFe", namespace = FIELD_NAMESPACE)
    private ProtNFe protNFe;

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ProtNFe {

        @XmlAttribute(name = "versao")
        private String versao;

        @XmlElement(name = "infProt", namespace = FIELD_NAMESPACE)
        private InfProt infProt;

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class InfProt {

            @XmlElement(name = "tpAmb", namespace = FIELD_NAMESPACE)
            private Integer tpAmb;

            @XmlElement(name = "verAplic", namespace = FIELD_NAMESPACE)
            private String verAplic;

            @XmlElement(name = "chNFe", namespace = FIELD_NAMESPACE)
            private String chNFe;

//            @XmlElement(name = "dhRecbto", namespace = "http://www.portal.fazenda.gov.br/nfe/protNFe")
//            @XmlAdapter(LocalDateAdapter.class)
//            private LocalDate dhRecbto;

            @XmlElement(name = "nProt", namespace = FIELD_NAMESPACE)
            private String nProt;

            @XmlElement(name = "digVal", namespace = FIELD_NAMESPACE)
            private String digVal;

            @XmlElement(name = "cStat", namespace = FIELD_NAMESPACE)
            private Integer cStat;

            @XmlElement(name = "xMotivo", namespace = FIELD_NAMESPACE)
            private String xMotivo;
        }
    }
    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class NFe {

        @XmlElement(name = "infNFe", namespace = FIELD_NAMESPACE)
        private  InfNFe infNFe;

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class InfNFe {

            @XmlAttribute(name = "Id")
            private String idNfe;

            @XmlElement(name = "ide", namespace = FIELD_NAMESPACE)
            private List<Ide> ides = new ArrayList<Ide>();

            @XmlElement(name = "emit", namespace = FIELD_NAMESPACE)
            private  Emit emit;
            @Data
            @XmlAccessorType(XmlAccessType.FIELD)
            public static class Emit {

                @XmlElement(name = "CNPJ", namespace = FIELD_NAMESPACE)
                private String cnpj;

                @XmlElement(name = "xNome", namespace = FIELD_NAMESPACE)
                private String xNome;

                @XmlElement(name = "xFant", namespace = FIELD_NAMESPACE)
                private String xFant;

                @XmlElement(name = "enderEmit", namespace = FIELD_NAMESPACE)
                private EnderEmit enderEmit;

                @XmlElement(name = "IE", namespace = FIELD_NAMESPACE)
                private String ie;

                @XmlElement(name = "CRT", namespace = FIELD_NAMESPACE)
                private Integer crt;


                @XmlElement(name = "infNFe", namespace = FIELD_NAMESPACE)
                private  InfNFe infNFe;

                @Data
                @XmlAccessorType(XmlAccessType.FIELD)
                public static class EnderEmit {

                    @XmlElement(name = "xLgr", namespace = FIELD_NAMESPACE)
                    private String xLgr;

                    @XmlElement(name = "nro", namespace = FIELD_NAMESPACE)
                    private String nro;

                    @XmlElement(name = "xBairro", namespace = FIELD_NAMESPACE)
                    private String xBairro;

                    @XmlElement(name = "cMun", namespace = FIELD_NAMESPACE)
                    private Integer cMun;

                    @XmlElement(name = "xMun", namespace = FIELD_NAMESPACE)
                    private String xMun;

                    @XmlElement(name = "UF", namespace = FIELD_NAMESPACE)
                    private String uf;

                    @XmlElement(name = "CEP", namespace = FIELD_NAMESPACE)
                    private String cep;

                    @XmlElement(name = "cPais", namespace = FIELD_NAMESPACE)
                    private Integer cPais;

                    @XmlElement(name = "xPais", namespace = FIELD_NAMESPACE)
                    private String xPais;

                    @XmlElement(name = "fone", namespace = FIELD_NAMESPACE)
                    private String fone;
                }
            }

            @XmlElement(name = "dest", namespace = FIELD_NAMESPACE)
            private Dest dest;

            @Data
            @XmlAccessorType(XmlAccessType.FIELD)
            public static class Dest {

                @XmlElement(name = "CPF", namespace = FIELD_NAMESPACE)
                private String cpf;

                @XmlElement(name = "xNome", namespace = FIELD_NAMESPACE)
                private String xNome;

                @XmlElement(name = "enderDest", namespace = FIELD_NAMESPACE)
                private EnderDest enderDest;

                @XmlElement(name = "indIEDest", namespace = FIELD_NAMESPACE)
                private Integer indIEDest;

                @XmlElement(name = "email", namespace = FIELD_NAMESPACE)
                private String email;


                @Data
                @XmlAccessorType(XmlAccessType.FIELD)
                public static class EnderDest {

                    @XmlElement(name = "xLgr", namespace = FIELD_NAMESPACE)
                    private String xLgr;

                    @XmlElement(name = "nro", namespace = FIELD_NAMESPACE)
                    private String nro;

                    @XmlElement(name = "xBairro", namespace = FIELD_NAMESPACE)
                    private String xBairro;

                    @XmlElement(name = "cMun", namespace = FIELD_NAMESPACE)
                    private Integer cMun;

                    @XmlElement(name = "xMun", namespace = FIELD_NAMESPACE)
                    private String xMun;

                    @XmlElement(name = "UF", namespace = FIELD_NAMESPACE)
                    private String uf;

                    @XmlElement(name = "CEP", namespace = FIELD_NAMESPACE)
                    private String cep;

                    @XmlElement(name = "cPais", namespace = FIELD_NAMESPACE)
                    private Integer cPais;

                    @XmlElement(name = "xPais", namespace = FIELD_NAMESPACE)
                    private String xPais;

                    @XmlElement(name = "fone", namespace = FIELD_NAMESPACE)
                    private String fone;
                }
            }
//

            @XmlElement(name = "det", namespace = FIELD_NAMESPACE)
            private List<Det> Det;

            @Data
            @XmlAccessorType(XmlAccessType.FIELD)
            public static class Det {

                @XmlAttribute(name = "nItem")
                private String nItem;

                @XmlElement(name = "prod", namespace = FIELD_NAMESPACE)
                private Produto produto;




                @Data
                @XmlAccessorType(XmlAccessType.FIELD)
                public static class Produto {

                    @XmlElement(name = "cProd", namespace = FIELD_NAMESPACE)
                    private String cProd;

                    @XmlElement(name = "cEAN", namespace = FIELD_NAMESPACE)
                    private String cEAN;

                    @XmlElement(name = "xProd", namespace = FIELD_NAMESPACE)
                    private String xProd;

                    @XmlElement(name = "NCM", namespace = FIELD_NAMESPACE)
                    private String NCM;

                    @XmlElement(name = "CFOP", namespace = FIELD_NAMESPACE)
                    private String CFOP;

                    @XmlElement(name = "uCom", namespace = FIELD_NAMESPACE)
                    private String uCom;
                    @XmlElement(name = "qCom", namespace = FIELD_NAMESPACE)
                    private String qCom;

                    @XmlElement(name = "vUnCom", namespace = FIELD_NAMESPACE)
                    private String vUnCom;

                    @XmlElement(name = "vProd", namespace = FIELD_NAMESPACE)
                    private String vProd;

                    @XmlElement(name = "cEANTrib", namespace = FIELD_NAMESPACE)
                    private String cEANTrib;

                    @XmlElement(name = "uTrib", namespace = FIELD_NAMESPACE)
                    private String uTrib;

                    @XmlElement(name = "qTrib", namespace = FIELD_NAMESPACE)
                    private String qTrib;

                    @XmlElement(name = "vUnTrib", namespace = FIELD_NAMESPACE)
                    private String vUnTrib;

                    @XmlElement(name = "indTot", namespace = FIELD_NAMESPACE)
                    private Integer indTot;
                }

                @XmlElement(name = "imposto", namespace = FIELD_NAMESPACE)
                private Imposto impostos;
                @Data
                @XmlAccessorType(XmlAccessType.FIELD)
                public static class Imposto {

                    @XmlElement(name = "vTotTrib", namespace = FIELD_NAMESPACE)
                    private String vTotTrib;

                    @XmlElement(name = "ICMS", namespace = FIELD_NAMESPACE)
                    private Icms icms;

                    @XmlElement(name = "IPI", namespace = FIELD_NAMESPACE)
                    private Ipi ipi;

                    @XmlElement(name = "PIS", namespace = FIELD_NAMESPACE)
                    private Pis pis;

                    @XmlElement(name = "COFINS", namespace = FIELD_NAMESPACE)
                    private Cofins cofins;

                    @Data
                    @XmlAccessorType(XmlAccessType.FIELD)
                    public static class Icms {

                        @XmlElement(name = "ICMSSN101", namespace = FIELD_NAMESPACE)
                        private IcmsSn101 icmsSn101;
                    }

                    @Data
                    @XmlAccessorType(XmlAccessType.FIELD)
                    public static class IcmsSn101 {

                        @XmlElement(name = "orig", namespace = FIELD_NAMESPACE)
                        private Integer orig;

                        @XmlElement(name = "CSOSN", namespace = FIELD_NAMESPACE)
                        private String csosn;

                        @XmlElement(name = "pCredSN", namespace = FIELD_NAMESPACE)
                        private String pCredSN;

                        @XmlElement(name = "vCredICMSSN", namespace = FIELD_NAMESPACE)
                        private String vCredICMSSN;
                    }

                    @Data
                    @XmlAccessorType(XmlAccessType.FIELD)
                    public static class Ipi {

                        @XmlElement(name = "clEnq", namespace = FIELD_NAMESPACE)
                        private String clEnq;

                        @XmlElement(name = "CNPJProd", namespace = FIELD_NAMESPACE)
                        private String cnpjProd;

                        @XmlElement(name = "cEnq", namespace = FIELD_NAMESPACE)
                        private String cEnq;

                        @XmlElement(name = "IPINT", namespace = FIELD_NAMESPACE)
                        private IpiNt ipint;
                    }

                    @Data
                    @XmlAccessorType(XmlAccessType.FIELD)
                    public static class IpiNt {

                        @XmlElement(name = "CST", namespace = FIELD_NAMESPACE)
                        private String cst;
                    }

                    @Data
                    @XmlAccessorType(XmlAccessType.FIELD)
                    public static class Pis {

                        @XmlElement(name = "PISNT", namespace = FIELD_NAMESPACE)
                        private PisNt pisNt;
                    }

                    @Data
                    @XmlAccessorType(XmlAccessType.FIELD)
                    public static class PisNt {

                        @XmlElement(name = "CST", namespace = FIELD_NAMESPACE)
                        private String cst;
                    }

                    @Data
                    @XmlAccessorType(XmlAccessType.FIELD)
                    public static class Cofins {

                        @XmlElement(name = "COFINSNT", namespace = FIELD_NAMESPACE)
                        private CofinsNt cofinsNt;
                    }

                    @Data
                    @XmlAccessorType(XmlAccessType.FIELD)
                    public static class CofinsNt {

                        @XmlElement(name = "CST", namespace = FIELD_NAMESPACE)
                        private String cst;
                    }
                }
            }
              @XmlElement(name = "total", namespace = FIELD_NAMESPACE)
              private Total total;

            @XmlElement(name = "transp", namespace = FIELD_NAMESPACE)
            private Transp transp;


            @XmlElement(name = "pag", namespace = FIELD_NAMESPACE)
            private Pag pag;


            @Data
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlRootElement(name = "pag")
            public static class Pag {

                @XmlElement(name = "detPag")
                private DetPag detPag;

                @Data
                @XmlAccessorType(XmlAccessType.FIELD)
                public static class DetPag {

                    @XmlElement(name = "indPag")
                    private Integer indicadorPagamento;

                    @XmlElement(name = "tPag")
                    private String formaPagamento;

                    @XmlElement(name = "vPag")
                    private String valorPagamento;

                    @XmlElement(name = "card")
                    private Cartao cartao;

                    @Data
                    @XmlAccessorType(XmlAccessType.FIELD)
                    public static class Cartao {

                        @XmlElement(name = "tpIntegra")
                        private Integer tipoIntegracao;

                        @XmlElement(name = "CNPJ")
                        private String cnpj;

                        @XmlElement(name = "tBand")
                        private String bandeira;

                        @XmlElement(name = "cAut")
                        private String codigoAutorizacao;
                    }
                }
            }

            @XmlElement(name = "cobr", namespace = FIELD_NAMESPACE)
            private Cobr cobr;

            @XmlElement(name = "infAdic", namespace = FIELD_NAMESPACE)
            private InfAdic infAdic;
        }


        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlRootElement(name = "protNFe")
        public static class ProtocoloNFe {

            @XmlAttribute(name = "versao")
            private String versao;

            @XmlElement(name = "infProt")
            private InformacoesProtocolo informacoesProtocolo;

            @Data
            @XmlAccessorType(XmlAccessType.FIELD)
            public static class InformacoesProtocolo {

                @XmlElement(name = "tpAmb")
                private Integer tpAmb;

                @XmlElement(name = "verAplic")
                private String verAplic;

                @XmlElement(name = "chNFe")
                private String chNFe;
//
//                @XmlElement(name = "dhRecbto", namespace = "http://www.portal.fazenda.gov.br/nfe/protNFe")
//                @XmlAdapter(LocalDateAdapter.class)
//                private LocalDate dhRecbto;

                @XmlElement(name = "nProt")
                private String nProt;

                @XmlElement(name = "digVal")
                private String digVal;

                @XmlElement(name = "cStat")
                private Integer cStat;

                @XmlElement(name = "xMotivo")
                private String xMotivo;
            }
        }
        @XmlElement(name = "Signature")
        private Signature signature;

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlRootElement(name = "Signature")

        public static class Signature {

            @XmlElement(name = "SignedInfo")
            private SignedInfo signedInfo;

            @XmlElement(name = "SignatureValue")
            private String signatureValue;

            @XmlElement(name = "KeyInfo")
            private KeyInfo keyInfo;

            @Data
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlRootElement(name = "SignedInfo")
            public static class SignedInfo {

                @XmlElement(name = "CanonicalizationMethod")
                private CanonicalizationMethod canonicalizationMethod;

                @XmlElement(name = "SignatureMethod")
                private SignatureMethod signatureMethod;

                @XmlElement(name = "Reference")
                private Reference reference;

                @Data
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlRootElement(name = "CanonicalizationMethod")
                public static class CanonicalizationMethod {

                    @XmlAttribute(name = "Algorithm")
                    private String algorithm;
                }

                @Data
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlRootElement(name = "SignatureMethod")
                public static class SignatureMethod {

                    @XmlAttribute(name = "Algorithm")
                    private String algorithm;
                }

                @Data
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlRootElement(name = "Reference")
                public static class Reference {

                    @XmlAttribute(name = "URI")
                    private String uri;

                    @XmlElement(name = "Transforms")
                    private Transforms transforms;

                    @XmlElement(name = "DigestMethod")
                    private DigestMethod digestMethod;

                    @XmlElement(name = "DigestValue")
                    private String digestValue;

                    @Data
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlRootElement(name = "Transforms")
                    public static class Transforms {

                        @XmlElement(name = "Transform")
                        private List<Transform> transform;

                        @Data
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlRootElement(name = "Transform")
                        public static class Transform {

                            @XmlAttribute(name = "Algorithm")
                            private String algorithm;
                        }
                    }

                    @Data
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlRootElement(name = "DigestMethod")
                    public static class DigestMethod {

                        @XmlAttribute(name = "Algorithm")
                        private String algorithm;
                    }
                }
            }

            @Data
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlRootElement(name = "KeyInfo")
            public static class KeyInfo {

                @XmlElement(name = "X509Data")
                private X509Data x509Data;

                @Data
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlRootElement(name = "X509Data")
                public static class X509Data {

                    @XmlElement(name = "X509Certificate")
                    private String x509Certificate;
                }
            }
        }
        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Ide {
            @XmlElement(name = "cUF", namespace = FIELD_NAMESPACE)
            private String cUF;

            @XmlElement(name = "cNF", namespace = FIELD_NAMESPACE)
            private String cNF;

            @XmlElement(name = "natOp", namespace = FIELD_NAMESPACE)
            private String natOp;

            @XmlElement(name = "indPag", namespace = FIELD_NAMESPACE)
            private int indPag;

            @XmlElement(name = "mod", namespace = FIELD_NAMESPACE)
            private int mod;

            @XmlElement(name = "serie", namespace = FIELD_NAMESPACE)
            private String serie;

            @XmlElement(name = "nNF", namespace = FIELD_NAMESPACE)
            private String nNF;

//        @XmlElement(name = "dhEmi")
//        @XmlSchemaType(type = XMLType.dateTime)
//        private LocalDateTime dhEmi;
//
//        @XmlElement(name = "dhSaiEnt")
//        @XmlSchemaType(type = XMLType.dateTime)
//        private LocalDateTime dhSaiEnt;

            @XmlElement(name = "tpNF", namespace = FIELD_NAMESPACE)
            private int tpNF;

            @XmlElement(name = "idDest", namespace = FIELD_NAMESPACE)
            private int idDest;

            @XmlElement(name = "cMunFG", namespace = FIELD_NAMESPACE)
            private String cMunFG;

            @XmlElement(name = "tpImp", namespace = FIELD_NAMESPACE)
            private int tpImp;

            @XmlElement(name = "tpEmis", namespace = FIELD_NAMESPACE)
            private int tpEmis;

            @XmlElement(name = "cDV", namespace = FIELD_NAMESPACE)
            private String cDV;

            @XmlElement(name = "tpAmb", namespace = FIELD_NAMESPACE)
            private int tpAmb;

            @XmlElement(name = "finNFe", namespace = FIELD_NAMESPACE)
            private int finNFe;

            @XmlElement(name = "indFinal", namespace = FIELD_NAMESPACE)
            private int indFinal;

            @XmlElement(name = "indPres", namespace = FIELD_NAMESPACE)
            private int indPres;

            @XmlElement(name = "procEmi", namespace = FIELD_NAMESPACE)
            private int procEmi;

            @XmlElement(name = "verProc", namespace = FIELD_NAMESPACE)
            private String verProc;
        }



        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Total {

            @XmlElement(name = "ICMSTot", namespace = FIELD_NAMESPACE)
            private IcmsTotal icmsTotal;

            @Data
            @XmlAccessorType(XmlAccessType.FIELD)
            public static class IcmsTotal {

                @XmlElement(name = "vBC", namespace = FIELD_NAMESPACE)
                private String vBC;

                @XmlElement(name = "vICMS", namespace = FIELD_NAMESPACE)
                private String vICMS;

                @XmlElement(name = "vICMSDeson", namespace = FIELD_NAMESPACE)
                private String vICMSDeson;

                @XmlElement(name = "vBCST", namespace = FIELD_NAMESPACE)
                private String vBCST;

                @XmlElement(name = "vST", namespace = FIELD_NAMESPACE)
                private String vST;

                @XmlElement(name = "vProd", namespace = FIELD_NAMESPACE)
                private String vProd;

                @XmlElement(name = "vFrete", namespace = FIELD_NAMESPACE)
                private String vFrete;

                @XmlElement(name = "vSeg", namespace = FIELD_NAMESPACE)
                private String vSeg;

                @XmlElement(name = "vDesc", namespace = FIELD_NAMESPACE)
                private String vDesc;

                @XmlElement(name = "vII", namespace = FIELD_NAMESPACE)
                private String vII;

                @XmlElement(name = "vIPI", namespace = FIELD_NAMESPACE)
                private String vIPI;

                @XmlElement(name = "vPIS", namespace = FIELD_NAMESPACE)
                private String vPIS;

                @XmlElement(name = "vCOFINS", namespace = FIELD_NAMESPACE)
                private String vCOFINS;

                @XmlElement(name = "vOutro", namespace = FIELD_NAMESPACE)
                private String vOutro;

                @XmlElement(name = "vNF", namespace = FIELD_NAMESPACE)
                private String vNF;

                @XmlElement(name = "vTotTrib", namespace = FIELD_NAMESPACE)
                private String vTotTrib;
            }
        }
    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Transp {

        @XmlElement(name = "modFrete", namespace = FIELD_NAMESPACE)
        private String modFrete;

        @XmlElement(name = "transporta", namespace = FIELD_NAMESPACE)
        private Transportadora transportadora;

        @XmlElement(name = "vol", namespace = FIELD_NAMESPACE)
        private Volume volume;

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Transportadora {

            @XmlElement(name = "xNome", namespace = FIELD_NAMESPACE)
            private String xNome;

            @XmlElement(name = "xEnder", namespace = FIELD_NAMESPACE)
            private String xEnder;

            @XmlElement(name = "xMun", namespace = FIELD_NAMESPACE)
            private String xMun;

            @XmlElement(name = "UF", namespace = FIELD_NAMESPACE)
            private String uf;
        }

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Volume {

            @XmlElement(name = "qVol", namespace = FIELD_NAMESPACE)
            private Integer qVol;

            @XmlElement(name = "marca", namespace = FIELD_NAMESPACE)
            private String marca;

            @XmlElement(name = "nVol", namespace = FIELD_NAMESPACE)
            private String nVol;

            @XmlElement(name = "pesoL", namespace = FIELD_NAMESPACE)
            private String pesoL;

            @XmlElement(name = "pesoB", namespace = FIELD_NAMESPACE)
            private String pesoB;
        }
    }
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public static class Cobr {

    @XmlElement(name = "fat", namespace = FIELD_NAMESPACE)
    private Fat fat;

    @XmlElement(name = "dup", namespace = FIELD_NAMESPACE)
    private Dup dup;

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Fat {

        @XmlElement(name = "nFat", namespace = FIELD_NAMESPACE)
        private String nFat;

        @XmlElement(name = "vOrig", namespace = FIELD_NAMESPACE)
        private String vOrig;

        @XmlElement(name = "vLiq", namespace = FIELD_NAMESPACE)
        private String vLiq;
    }

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Dup {

            @XmlElement(name = "nDup", namespace = FIELD_NAMESPACE)
            private String nDup;

    //        @XmlElement(name = "dVenc", namespace = FIELD_NAMESPACE)
    //        @XmlAdapter(LocalDateAdapter.class)
    //        private LocalDate dVenc;

            @XmlElement(name = "vDup", namespace = FIELD_NAMESPACE)
            private String vDup;
        }
    }
        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class InfAdic {

            @XmlElement(name = "infCpl", namespace = FIELD_NAMESPACE)
            private String informacoesComplementares;
        }


    }
}
