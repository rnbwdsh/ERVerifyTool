/*-
 * Copyright (c) 2017
 * Federal Office for Information Security (BSI),
 * Godesberger Allee 185-189,
 * 53175 Bonn, Germany,
 * phone: +49 228 99 9582-0,
 * fax: +49 228 99 9582-5400,
 * e-mail: bsi@bsi.bund.de
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.bund.bsi.tr_esor.checktool.validation.default_impl.basis.ers;


import org.bouncycastle.tsp.TimeStampToken;

import de.bund.bsi.ecard.api._1.ECard_Service;
import de.bund.bsi.tr_esor.checktool.validation.default_impl.ECardTimeStampValidator;
import de.bund.bsi.tr_esor.checktool.validation.report.FormatOkReport;


/**
 * Basis-ERS-Profil requirements for the time stamp inside an ArchiveTimeStamp. This performs an online
 * validation, see {@link ECardTimeStampValidator} for further details.
 *
 * @author MO
 */
public class BasisErsECardTimeStampValidator extends ECardTimeStampValidator
{

  /**
   * @see ECardTimeStampValidator#ECardTimeStampValidator()
   */
  public BasisErsECardTimeStampValidator()
  {
    super();
  }

  /**
   * @see ECardTimeStampValidator#ECardTimeStampValidator(ECard_Service)
   */
  public BasisErsECardTimeStampValidator(ECard_Service eCardWebService)
  {
    super(eCardWebService);
  }


  @Override
  protected void checkUnsignedAttributes(TimeStampToken ts, FormatOkReport formatOk)
  {
    super.checkUnsignedAttributes(ts, formatOk);
    var contentInfoChecker = new ContentInfoChecker(formatOk);
    contentInfoChecker.checkContentInfo(formatOk.getReference(), ts.toCMSSignedData().toASN1Structure());

  }
}
